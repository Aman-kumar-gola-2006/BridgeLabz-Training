package collectors.wordfrequencycounter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordOccurrence {
	public static void main(String[] args) {
		String paragraph = "Java is easy and Java is powerful and Java is popular";
		Map<String, Integer> wordCount = Arrays.stream(paragraph.toLowerCase().split("\\s+"))
				.collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

		wordCount.forEach((word, count) -> System.out.println(word + " : " + count));
	}
}
