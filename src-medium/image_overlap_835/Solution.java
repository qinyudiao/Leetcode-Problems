package image_overlap_835;

//	Two images A and B are given, represented as binary, square matrices of the same size. (A binary matrix has only 0s and 1s as values.)
//	We translate one image however we choose (sliding it left, right, up, or down any number of units), 
//	and place it on top of the other image. 
//	After, the overlap of this translation is the number of positions that have a 1 in both images.
//	
//	(Note also that a translation does not include any kind of rotation.)
//	
//	What is the largest possible overlap?

//	Notes: 
//		1. 1 <= A.length = A[0].length = B.length = B[0].length <= 30
//		2. 0 <= A[i][j], B[i][j] <= 1

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		int[][][] testCasesA = {{	{1, 1, 0}, 
									{0, 1, 0}, 
									{0, 1, 0}}}; // 3
		int[][][] testCasesB = {{	{0, 0, 0}, 
								 	{0, 1, 1}, 
								 	{0, 0, 1}}};
		for(int i = 0; i < testCasesA.length; i++) {
			System.out.println(solution.largestOverlap(testCasesA[i], testCasesB[i]));	
		}
	}

    // O(n^4)
    public int largestOverlap(int[][] A, int[][] B) {
        int result = 0;
        for(int i = 0; i < A.length;i++) {
            for(int j = 0; j < A.length; j++) {
                result = Math.max(result, getOverlap(A, B, i,j));
                result = Math.max(result, getOverlap(B, A, i,j));
            }
        }
        
        return result;
    }
    
	// O(n^2)
    private int getOverlap(int[][] fixed, int[][] sliding, int sliding_i, int sliding_j) {
        int count = 0;
        for(int i = sliding_i, fixed_i = 0; i < fixed.length; i++){
            for(int j = sliding_j, fixed_j = 0; j < fixed.length; j++){
                if(sliding[i][j] == 1 && fixed[fixed_i][fixed_j] == 1)
                    count++;
                fixed_j++;
            }
            fixed_i++;
        }
        
        return count;
    }
}

//	Runtime: 16 ms, faster than 86.43% of Java online submissions for Image Overlap.
//	Memory Usage: 38.8 MB, less than 88.22% of Java online submissions for Image Overlap.

