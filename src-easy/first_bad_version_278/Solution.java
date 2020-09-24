package first_bad_version_278;

//	You are a product manager and currently leading a team to develop a new product. 
//	Unfortunately, the latest version of your product fails the quality check. 
//	Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//	Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
//	which causes all the following ones to be bad.
//
//	You are given an API bool isBadVersion(version) which will return whether version is bad. 
//	Implement a function to find the first bad version. 
//	You should minimize the number of calls to the API.

/**
 *  The isBadVersion API is defined in the parent class VersionControl.
 * 	boolean isBadVersion(int version);
 */

class VersionControl {
	private int firstBad = 6;
	
	boolean isBadVersion(int n) {
		if(n >= firstBad)
			return true;
		else
			return false;
	}
	
	protected void setFirstBad(int n) {
		this.firstBad = n;
	}
}

public class Solution extends VersionControl {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] testCases = { { 1, 1 }, { 6, 10 }, { 8, 10 }, { 2, 10 }, { 55, 100 }, { 177, 177 }, {222123, 321312}, {1702766719, 2126753390}, {2147483647, 2147483647}}; // {guessedNumber, n}
		
		for(int[] testCase : testCases) {
			solution.setFirstBad(testCase[0]);
			System.out.println(" ------ " + solution.firstBadVersion(testCase[1]));	
		}
	}
	
	public int firstBadVersion(int n) {
		int l = 1, r = n;
		while (l <= r) {
			int m = l + (r - l) / 2; // can't use (l + r) / 2, because l + r could be larger than Integer.MAX_VALUE
			if(isBadVersion(m))
				r = m - 1;
			else
				l = m + 1;
	//		System.out.print("l:" + l + " m:" + m + " r:" + r + " ; ");
		}
 
		return Math.max(l, r);
	}
}

//	Runtime: 12 ms, faster than 99.30% of Java online submissions for First Bad Version.
//	Memory Usage: 36.2 MB, less than 62.89% of Java online submissions for First Bad Version.
