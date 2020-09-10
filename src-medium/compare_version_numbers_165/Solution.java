package compare_version_numbers_165;

//	Compare two version numbers version1 and version2.
//	If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
//	
//	You may assume that the version strings are non-empty and contain only digits and the . character.
//	
//	The . character does not represent a decimal point and is used to separate number sequences.
//	
//	For instance, 2.5 is not "two and a half" or "half way to version three", 
//	it is the fifth second-level revision of the second first-level revision.
//	
//	You may assume the default revision number for each level of a version number to be 0. 
//	For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. 
//	Its third and fourth level revision number are both 0.

//	Note:
//		1. Version strings are composed of numeric strings separated by dots . and this numeric strings may have leading zeroes.
//		2. Version strings do not start or end with dots, and they will not be two consecutive dots.

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] testCasesVersion1 = {"0.1", "1.0.1", "7.5.2.4", "1.01", "1.0", "0.9.9.9.9.9.9.9.9.9.9.9.9"}; // -1, 1, -1, 0, 0, -1
		String[] testCasesVersion2 = {"1.1", "1", "7.5.3", "1.001", "1.0.0", "1.0"};
		
		for(int i = 0; i < testCasesVersion1.length; i++) {
			System.out.println(solution.compareVersion(testCasesVersion1[i], testCasesVersion2[i]));
		}
	}

	public int compareVersion(String version1, String version2) {
		String[] strV1 = version1.split("\\.");
		String[] strV2 = version2.split("\\.");
		int numLevels = Math.max(strV1.length, strV2.length);
		int[] numV1 = new int[numLevels];
		int[] numV2 = new int[numLevels];
		for(int i = 0; i < strV1.length; i++) {
			numV1[i] = Integer.parseInt(strV1[i]);
		}
		for(int i = 0; i < strV2.length; i++) {
			numV2[i] = Integer.parseInt(strV2[i]);
		}
		
		for(int i = 0; i < numLevels; i++) {
			if(numV1[i] > numV2[i])
				return 1;
			else if(numV1[i] < numV2[i])
				return -1;
		}
		
		return 0;
    }
}

//	Runtime: 1 ms, faster than 92.95% of Java online submissions for Compare Version Numbers.
//	Memory Usage: 37.2 MB, less than 91.54% of Java online submissions for Compare Version Numbers.
