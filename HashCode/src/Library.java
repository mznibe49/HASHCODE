import java.util.TreeSet;

public class Library implements Comparable<Library> {
    private TreeSet<Book> bookSet;

    private int ratio;
    private int id;
    private int totalBooks;
    private int time;
    private int booksByDay;

    public Library() {
        this.bookSet = new TreeSet<>();
    }

    public Library(int id, int time, int booksByDay) {
        this.id = id;
        this.time = time;
        this.booksByDay = booksByDay;
    }

    @Override
    public int compareTo(Library library) {
        return (this.ratio < library.ratio) ? -1 : (this.ratio > library.ratio) ? + 1 : 0;
    }

    @Override
    public String toString() {
        String result = "LIBRARY " + id;
        result += "\ntotal Books : " + totalBooks;
        result += "\ntime : " + time;
        result += "\nbooksByDay " + booksByDay;

        for (Book book : this.bookSet) {
            result += "\n" + book.toString();
        }

        return result;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public int getTime() {
        return time;
    }

    public int getBooksByDay() {
        return booksByDay;
    }

    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public void setBooksByDay(int booksByDay) {
        this.booksByDay = booksByDay;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setBookSet(TreeSet<Book> bookSet) {
        this.bookSet = bookSet;
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

    public int getRatio() {
        return ratio;
    }

    public void setRatio(){
        try {
            this.ratio = getLibScore()/(getTime()+(totalBooks/booksByDay));
        } catch (Exception e ) {
            this.ratio = 0;
        }
    }
}
