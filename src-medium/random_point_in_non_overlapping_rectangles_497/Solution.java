package random_point_in_non_overlapping_rectangles_497;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//	Given a list of non-overlapping axis-aligned rectangles rects, 
//	write a function pick which randomly and uniformily picks an integer point in the space covered by the rectangles.
//	
//	Note:
//		1. An integer point is a point that has integer coordinates. 
//		2. A point on the perimeter of a rectangle is included in the space covered by the rectangles. 
//		3. ith rectangle = rects[i] = [x1,y1,x2,y2], 
//			where [x1, y1] are the integer coordinates of the bottom-left corner, 
//			and [x2, y2] are the integer coordinates of the top-right corner.
//		4. length and width of each rectangle does not exceed 2000.
//		5. 1 <= rects.length <= 100
//		6. pick return a point as an array of integer coordinates [p_x, p_y]
//		7. pick is called at most 10000 times.

/**
 * Your evaluate_division_399.Solution object will be instantiated and called as such:
 * evaluate_division_399.Solution obj = new evaluate_division_399.Solution(rects);
 * int[] param_1 = obj.pick();
 */

public class Solution {
	
	private int[][] rects;
	private int totalArea;
	private List<Integer> area_index = new ArrayList<>();
	
//	The input is two lists: the subroutines called and their arguments. 
//	evaluate_division_399.Solution's constructor has one argument, the array of rectangles rects.
//	pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
	public static void main(String[] args) {
		int[][] rects = {
//				{1, 1, 5,
				{-2, -2, -1, -1},
				{1, 0, 3, 0},
		};
		Solution solution = new Solution(rects);
		System.out.println("totalArea: " + solution.totalArea);
		System.out.println("area_index: " + solution.area_index);
		System.out.println(Arrays.toString(solution.pick()));
	}

	public Solution(int[][] rects) {
		this.rects = rects;
		setVariables(rects);
	}
    
	public int[] pick() {
    	
		Random rand = new Random();

		int point_index = rand.nextInt(totalArea);
		point_index = 6;
		int[] pickedRect = {};
		for(int i = 0; i < area_index.size(); i++) {
			 if(point_index < area_index.get(i)) {
				 pickedRect = rects[i];
				 System.out.println("point_index: " + point_index);
				 if(i > 0)
					 point_index -= area_index.get(i - 1);
				 System.out.println("point_index: " + point_index);
				 break;
			 }
		}

		int height = (pickedRect[3] - pickedRect[1] + 1);
		int width = (pickedRect[2] - pickedRect[0] + 1);

		System.out.println("height: " + height + " width: " + width);

		return new int[] {pickedRect[0] + (point_index % width), pickedRect[1] + (point_index / width)};
	}
    
	private void setVariables(int[][] rects) {
		int totalArea = 0;
		for(int i = 0; i < rects.length; i++) {
			int[] rect = rects[i];
			int area = (rect[3] - rect[1] + 1) * (rect[2] - rect[0] + 1);
			totalArea += area;
			area_index.add(totalArea);
		}
		this.totalArea = totalArea;
	}
}

//	Runtime: 60 ms, faster than 64.74% of Java online submissions for Random Point in Non-overlapping Rectangles.
//	Memory Usage: 45.9 MB, less than 76.29% of Java online submissions for Random Point in Non-overlapping Rectangles.
