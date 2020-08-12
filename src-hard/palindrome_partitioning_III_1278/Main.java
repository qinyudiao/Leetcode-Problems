package palindrome_partitioning_III_1278;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();
		ArrayList<String> l1 = new ArrayList<>();
		ArrayList<Integer> l2 = new ArrayList<>();
		ArrayList<Integer> l3 = new ArrayList<>();
		
		l1.add("abc");
		l2.add(2);
		l3.add(1);
		
		l1.add("aabbc");
		l2.add(3);
		l3.add(0);
		
		l1.add("leetcode");
		l2.add(8);
		l3.add(0);
		
		
		for(int i=0; i<l1.size(); i++) {
//			System.out.println("Input: " + "\"" + l1.get(i) + "\", " + l2.get(i) + " Output: " + s.palindromePartition("abc", 2) + ", should be " + l3.get(i));
			System.out.println(s.palindromePartition(l1.get(i), l2.get(i)) == l3.get(i));
		}
	}
	
}
