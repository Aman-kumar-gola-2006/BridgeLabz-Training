package interfaces.functionalinterface.stringlengthchecker;

import java.util.function.Function;

public class StringLengthChecker {
	public static void main(String[] args) {
		String message = "Hello";

		Function<String, Integer> checkLimit = characters -> message.length();
		int limit = checkLimit.apply(message);

		if (limit > 10) {
			System.out.println("Word Limit Exceeds");
		} else {
			System.out.println(message);
		}
	}
}
