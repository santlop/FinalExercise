package utils;

import java.util.*;

public class Utils {
	public int random(int number) {
		Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(number) + 1;
	    return randomInt;
	}
}
