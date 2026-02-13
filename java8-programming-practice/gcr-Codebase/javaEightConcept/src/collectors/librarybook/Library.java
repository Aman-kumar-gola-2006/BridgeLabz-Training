package collectors.librarybook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class Library {
	
	public static void main(String[] args) {
		List<Book> list=new ArrayList<Book>();
		list.add(new Book("horror", 1000));
		list.add(new Book("comedy", 1900));
		list.add(new Book("fiction", 7100));
		list.add(new Book("comedy", 1070));
		list.add(new Book("horror", 1200));
		list.add(new Book("fiction", 1000));
		list.add(new Book("horror", 1030));
		
		 Map<String, IntSummaryStatistics> statsByGenre =
	                list.stream()
	                     .collect(Collectors.groupingBy(
	                             Book::getGenre,
	                             Collectors.summarizingInt(Book::getPages)
	                     ));
		 
		 statsByGenre.forEach((genre, stats) -> {
	            System.out.println("Genre: " + genre);
	            System.out.println("Total Pages: " + stats.getSum());
	            System.out.println("Average Pages: " + stats.getAverage());
	            System.out.println("Max Pages: " + stats.getMax());
	            System.out.println("Min Pages: " + stats.getMin());
	            System.out.println("------------------");
	        });
	}

}