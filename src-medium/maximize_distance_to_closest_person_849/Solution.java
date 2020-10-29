package maximize_distance_to_closest_person_849;

//    You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, 
//    and seats[i] = 0 represents that the ith seat is empty (0-indexed).
//    
//    There is at least one empty seat, and at least one person sitting.
//    
//    Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 
//    
//    Return that maximum distance to the closest person.

//    Constraints:
//        2 <= seats.length <= 2 * 104
//        seats[i] is 0 or 1.
//        At least one seat is empty.
//        At least one seat is occupied.

public class Solution {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int testCases[][] = {{1, 0, 0, 0, 1, 0, 1}, {1, 0, 0, 0}, {0, 1}, {0, 0, 0, 1, 0, 0, 0, 0, 1}}; // 2, 3, 1, 3
        for(int[] testCase : testCases) {
            System.out.println(solution.maxDistToClosest(testCase));
        }
    }
    
    public int maxDistToClosest(int[] seats) {
        int max = 1;
        
        int countLeadingZeros = 0;
        for(int seat : seats) {
            if(seat == 0)
                countLeadingZeros++;
            else
                break;
        }
        
        int count = 0;
        for(int i = countLeadingZeros + 1; i < seats.length; i++) {
            if(seats[i] == 0)
                count++;
            else {
                if(count > max)
                    max = count;
                count = 0;
            }
        }
        
        // Edge cases for leading zeros or ending zeros
        if(Math.max(countLeadingZeros, count) > max / 2)
            return Math.max(countLeadingZeros, count);
        
        return (max + 1) / 2;
    }
}

//    Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximize Distance to Closest Person.
//    Memory Usage: 40.9 MB, less than 10.81% of Java online submissions for Maximize Distance to Closest Person.
