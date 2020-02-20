public class Book {
    private int id;
    private int score;

    public Book(int id, int score) {
        this.id = id;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Book)) {
            return false;
        }

        Book book = (Book) o;

        return this.id == book.getId() && this.score == book.score;
    }

    @Override
    public String toString() {
        return ("id : " + this.id + "score : " + this.score);
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }
}
