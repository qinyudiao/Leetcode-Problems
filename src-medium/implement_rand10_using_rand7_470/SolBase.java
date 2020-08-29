package implement_rand10_using_rand7_470;

import java.util.Random;

public class SolBase {
	public int rand7() {
		Random rand = new Random();
		return rand.nextInt(7) + 1;
	}
}
