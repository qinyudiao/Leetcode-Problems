package battleships_in_a_board_419;

//    Given an 2D board, count how many battleships are in it. 
//    The battleships are represented with 'X's, empty slots are represented with '.'s. 
//    You may assume the following rules:
//        You receive a valid board, made of only battleships or empty slots.
//        Battleships can only be placed horizontally or vertically. 
//        In other words, they can only be made of the shape 1xN (1 row, N columns) 
//        or Nx1 (N rows, 1 column), where N can be of any size.
//        At least one horizontal or vertical cell separates between two battleships 
//        - there are no adjacent battleships.

//    Follow up:
//        Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][][] testCases = {{{'X', '.', 'X', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}},
                {{'.', '.', '.', 'X'}, {'X', 'X', 'X', '.'}, {'.', '.', '.', 'X'}}}; // 2, 3
        for(char[][] testCase : testCases) {
            System.out.println(solution.countBattleships(testCase));
        }
    }

    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'X' && (i == 0 || board[i - 1][j] == '.') && (j == 0 || board[i][j - 1] == '.'))
                    count++;
            }
        }
        
        return count;
    }
}
