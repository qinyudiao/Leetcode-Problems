package can_place_flowers_605;

//	Suppose you have a long flowerbed in which some of the plots are planted and some are not. 
//	However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
//
//	Given a flowerbed (represented as an array containing 0 and 1, 
//	where 0 means empty and 1 means not empty), and a number n, 
//	return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

//	Note:
//		1. The input array won't violate no-adjacent-flowers rule.
//		2. The input array size is in the range of [1, 20000].
//		3. n is a non-negative integer which won't exceed the input array size.

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 1)); // true
		System.out.println(solution.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2)); // false
		System.out.println(solution.canPlaceFlowers(new int[] {1, 0, 0, 0, 0, 1}, 2)); // false
		System.out.println(solution.canPlaceFlowers(new int[] {1}, 0)); // true
		System.out.println(solution.canPlaceFlowers(new int[] {0}, 1)); // true
		
	}
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		// flowerbed.length < 3, check separately
		if(flowerbed.length < 3) {
			int sum = 0;
			for(int i: flowerbed) {
				sum += i;
			}
			return sum == 0? n <= 1 : n == 0;
		}

		int count = 0;
		// base case
		if(flowerbed[0] + flowerbed[1] == 0) {
			flowerbed[0] = 1;
			count++;
			if(count >= n)
				return true;
		}
        	
		for(int i = 1; i < flowerbed.length - 1; i++) {
			if(flowerbed[i-1] + flowerbed[i] + flowerbed[i+1] == 0) {
				flowerbed[i] = 1;
				count++;
			}
	//        	System.out.println(count);
			if(count >= n)
				return true;
		}
        
		// end edge case
		if(flowerbed[flowerbed.length - 2] + flowerbed[flowerbed.length - 1] == 0) {
			flowerbed[flowerbed.length - 1] = 1;
			count++;
			if(count >= n)
				return true;
		}
		
		return false;
	}
}

//	Runtime: 1 ms, faster than 97.07% of Java online submissions for Can Place Flowers.
//	Memory Usage: 41 MB, less than 68.10% of Java online submissions for Can Place Flowers.
