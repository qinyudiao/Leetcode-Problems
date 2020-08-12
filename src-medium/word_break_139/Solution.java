package word_break_139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

//	Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
//	determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//	Note:
//		The same word in the dictionary may be reused multiple times in the segmentation.
//		ou may assume the dictionary does not contain duplicate words.
@SuppressWarnings("unused")
public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = "leetcode";
		String s2 = "applecpenapple"; // 0 5 5 6 6 9 9 14
		String s3 = "catsandog";
		List<String> wl1 = Arrays.asList("leet", "code");
		List<String> wl2 = Arrays.asList("apple", "pen", "c");
		List<String> wl3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
		
		
		System.out.println(solution.wordBreak(s1, wl1));
		System.out.println(solution.wordBreak(s2, wl2));
		System.out.println(solution.wordBreak(s3, wl3));
		
		String s4 = "catsanddog";
		List<String> wl4 = Arrays.asList("cats", "dog", "and", "cat");
		System.out.println(solution.wordBreak(s4, wl4));
		
		String s5 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> wl5 = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		System.out.println(solution.wordBreak(s5, wl5));
	}
	
	/**
	 * @author Jack Diao
	 * @method wordBreak
	 * @despription solve the problem using dp
	 * @runtime O(n*m*l), where n is s.length(), m is max_word_length in wordDict, l is wordDict.size().
	 */
	public boolean wordBreak(String s, List<String> wordDict) {
		int max_word_length = 0;
		for(String word: wordDict) {
			max_word_length = Math.max(max_word_length, word.length());
		}
		
		ArrayList<TreeSet<Integer>> dp = new ArrayList<>();
		for(int i=0; i<s.length(); i++) {	// O(n*m*l)
			dp.add(new TreeSet<Integer>());
			for(int j=1; j<=max_word_length && i+j<=s.length(); j++) {
				if(wordDict.contains(s.substring(i, i+j)))
					dp.get(i).add(i+j);
//				System.out.print(wordDict.contains(s.substring(i, i+j)) ? "1 " : "0 ");
			}
//			System.out.println();
		}
		
		System.out.println(dp);
		
		/* DFS: O(n+m*n)/O(v+e) where v=n, e=m*n */
		
		int index = 0; // start at 0
		Stack<Integer> stack = new Stack<Integer>();
		while(index<s.length()) {
			TreeSet<Integer> targets = dp.get(index);
			if(!targets.isEmpty()) {
				stack.push(index);
				index = targets.first();
				if(index == s.length())
					return true;
				targets.remove(index);
			}
			else if(stack.isEmpty()) {
				break;
			}
			else {
				index = stack.pop();
			}
		}
			
		return false;
	}
	
	// using stack
	public boolean wordBreak1(String s, List<String> wordDict) {
		int max_word_length = 0;
		for(String word: wordDict) {
			max_word_length = Math.max(max_word_length, word.length());
		}
		
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
			
			System.out.println(r);
		}
		
//		System.out.println(visited);
//		System.out.println(stack);
		
		if(!stack.isEmpty() && stack.pop()==s.length()) // if the right index of the last matched substring is at the rightmost index, then s can be segmented
			return true;
		
		return false;
    }
}
