package genericUlities;

import java.util.Random;

public class JavaUtility {
	
	public int GetRandom() {
		Random ran = new Random();
		int random=ran.nextInt(200);
		return random;
	}

}
