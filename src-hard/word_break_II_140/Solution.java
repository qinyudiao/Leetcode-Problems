package word_break_II_140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = "catsanddog";
		List<String> wl1 = Arrays.asList("cat", "cats", "and", "sand", "dog");
		System.out.println(solution.wordBreak(s1, wl1));
		
		String s2 = "pineapplepenapple";
		List<String> wl2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
		System.out.println(solution.wordBreak(s2, wl2));
		
		String s3 = "catsandog";
		List<String> wl3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
		System.out.println(solution.wordBreak(s3, wl3));
		
		String s4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<String> wl4 = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		System.out.println(solution.wordBreak(s4, wl4));
	}
	
	/**
	 * @author Jack Diao
	 */
	public List<String> wordBreak(String s, List<String> wordDict) {
		System.out.println("s.length():" + s.length());
		int max_word_length = getMaxWordLength(wordDict);
		if(!wordBreak1(s, wordDict, max_word_length))
			return new ArrayList<>();
		
		List<TreeSet<Integer>> dp = getDp(s, wordDict, max_word_length); // dp as adjancency list
//		System.out.println("dp: " + dp);
		
		List<List<Integer>> paths = new ArrayList<>();
		
		dfs_al(dp, 0, dp.size() - 1, new ArrayList<>(), paths);

//		System.out.println("dp.size: " + dp.size() + "	s.length():" + s.length());
//		System.out.println("paths: " + paths);
			
		return getFilledSetences(paths, s);
	}
	
	/**
	 * @param graph - adajcency list
	 * @param source - source node
	 * @param destiniation - destination node
	 * @param list
	 * @param result
	 * @return
	 */
	private void dfs_al(List<TreeSet<Integer>> graph, int source, int destination, List<Integer> list, List<List<Integer>> result) {
        if(source == destination)
        	result.add(list); // if soruce reached destination, add path in result
        list.add(source); // add current vertex
        for(Integer vertex : graph.get(source)) {
            List<Integer> copiedList = new ArrayList<>(list); // clone the path
            dfs_al(graph, vertex, destination, copiedList, result);
        }
    }
	
	private int getMaxWordLength(List<String> wordDict) {
		int max_word_length = 0;
		for(String word: wordDict) {
			max_word_length = Math.max(max_word_length, word.length());
		}
		return max_word_length;
	}

	private ArrayList<TreeSet<Integer>> getDp(String s, List<String> wordDict, int max_word_length) {
		ArrayList<TreeSet<Integer>> dp = new ArrayList<>();
		for(int i=0; i<=s.length(); i++) {	// O(n*m*l)
			dp.add(new TreeSet<Integer>());
			for(int j=1; j<=max_word_length && i+j<=s.length(); j++) {
				if(wordDict.contains(s.substring(i, i+j)))
					dp.get(i).add(i+j);
//				System.out.print(wordDict.contains(s.substring(i, i+j)) ? "1 " : "0 ");
			}
//			System.out.println();
		}
		return dp;
	}
	
	private List<String> getFilledSetences(List<List<Integer>> paths, String s) {
		List<String> sentences = new ArrayList<>();
		for(List<Integer> path: paths) {
			String sentence = "";
			int i = 0;
			while(i<path.size()-2) {
				sentence = sentence + s.substring(path.get(i), path.get(i+1)) + " ";
				i++;
			}
			sentence += s.substring(path.get(i), path.get(i+1));
			sentences.add(sentence);
		}
		return sentences;
	}
	
	public boolean wordBreak1(String s, List<String> wordDict, int max_word_length) {
		int l = 0;
		int r = 1;
		Stack<Integer> stack = new Stack<Integer>();
		HashSet<Integer> visited = new HashSet<>();
		
		while(r<=s.length()) {
			if(!visited.contains(r) && wordDict.contains(s.substring(l, r))) { // if finds a match, push left/right indices to the stack and update
				stack.push(l);
				stack.push(r);
				l=r;
				r++;		
			}
			else {
				if(!stack.empty() && (r==s.length() || r-l >= max_word_length)) { // if reaches the end or larger than max word length, reverse the last matched indices
					r = stack.pop();
					l = stack.pop();
					visited.add(r);
				}
				else if(r-l >= max_word_length)
					break;
				r++;
			}
			
		}
		
		if(!stack.isEmpty() && stack.pop()==s.length()) // if the right index of the last matched substring is at the rightmost index, then s can be segmented
			return true;
		
		return false;
	}
}
