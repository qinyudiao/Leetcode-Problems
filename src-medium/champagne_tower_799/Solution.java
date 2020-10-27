package champagne_tower_799;

//    We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row. 
//    Each glass holds one cup of champagne.
//    
//    Then, some champagne is poured into the first glass at the top. 
//    When the topmost glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.
//    When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on. 
//    (A glass at the bottom row has its excess champagne fall on the floor.)
//    
//    For example, after one cup of champagne is poured, the top most glass is full.
//    After two cups of champagne are poured, the two glasses on the second row are half full. 
//    After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now. 
//    After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full
//    
//    Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)

//    Constraints:
//        0 <= poured <= 109
//        0 <= query_glass <= query_row < 100

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int[] testCasesPoured = {1, 2, 100000009}; // 0.0, 0.5, 1.0
        int[] testCasesQueryRow = {1, 1, 33};
        int[] testCasesQueryGlass = {1, 1, 17};
        
        for(int i = 0; i < testCasesPoured.length; i++) {
            System.out.println(solution.champagneTower(testCasesPoured[i], testCasesQueryRow[i], testCasesQueryGlass[i]));
        }
    }
    
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] prevFlow = {(double) poured};
        for(int i = 1; i <= query_row; i++) {
            double[] currFlow = new double[i + 1];
            for(int j = 0; j < i; j++) {
                double flowFall = Math.max(0.0, (prevFlow[j] - 1.0) / 2.0); // The flow that previous glass falls to each of the two next glasses.
                currFlow[j] += flowFall;
                currFlow[j + 1] += flowFall;
            }
            prevFlow = currFlow;
        }
        return Math.min(1.0, prevFlow[query_glass]);
    }
}
