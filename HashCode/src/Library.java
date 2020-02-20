import java.util.TreeSet;

public class Library {
    private TreeSet<Book> bookSet;
    private int time;
    private int booksByDay;

    public Library(int time, int booksByDay) {
        this.time = time;
        this.booksByDay = booksByDay;
    }

    public int getTime() {
        return time;
    }

    public int getBooksByDay() {
        return booksByDay;
    }

    public boolean addBook(Book book) {
        return this.bookSet.add(book);
    }

    public Book getHighest() {
        return this.bookSet.pollLast();
    }

	public int getLibScore(){
		int total = 0;
		for (Book b : bookSet){
			total += b.getScore();
		}
		return total;
	}
}
