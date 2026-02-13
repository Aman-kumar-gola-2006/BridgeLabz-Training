package collectors.librarybook;

public class Book {

	String genre;
	int pages;

	public Book(String genre, int pages) {
		// TODO Auto-generated constructor stub
		this.genre = genre;
		this.pages=pages;
	}
	
	public String getGenre() {
        return genre;
    }

    public int getPages() {
        return pages;
    }
	
	@Override
 public	String toString()
	{
		return "Book Genre : " + genre + "  Book pages" + pages;
	}
}