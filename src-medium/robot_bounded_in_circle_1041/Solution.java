package robot_bounded_in_circle_1041;

//	On an infinite plane, a robot initially stands at (0, 0) and faces north. 
//	The robot can receive one of three instructions:
//	
//	"G": go straight 1 unit;
//	"L": turn 90 degrees to the left;
//	"R": turn 90 degress to the right.
//	The robot performs the instructions given in order, and repeats them forever.
//	
//	Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

//	Note:
//		1. 1 <= instructions.length <= 100
//		2. instructions[i] is in {'G', 'L', 'R'}

public class Solution {

	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String[] testCases = {"GGLLGG", "GG", "GL", "GGRLLR", "GGRGLGRG", "GLRLLGLL"}; // true, false, true, flase, true, true
		for(String testCase : testCases) {
			System.out.println(solution.isRobotBounded(testCase));
		}
	}

	public boolean isRobotBounded(String instructions) {
		final int NORTH = 0, EAST = 1, SOUTH = 2, WEST = 3;
		int direction = NORTH;
		int x = 0, y = 0;
		for(int i = 0; i < instructions.length(); i++) {
			if(instructions.charAt(i) == 'L') {
				direction++;
				direction = direction >= 4 ? 0 : direction;
			}
			else if(instructions.charAt(i) == 'R') {
				direction--;
				direction = direction <= -1 ? 3 : direction;
			}
			else {
				switch(direction) {
					case NORTH:
						y++;
						break;
					case EAST:
						x++;
						break;
					case SOUTH:
						y--;
						break;
					case WEST:
						x--;
				}
			}
		}
		
		return direction != 0 || (x == 0 && y == 0);
    }
}

//	Runtime: 0 ms, faster than 100.00% of Java online submissions for Robot Bounded In Circle.
//	Memory Usage: 36.8 MB, less than 98.83% of Java online submissions for Robot Bounded In Circle.
