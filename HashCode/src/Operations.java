import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Operations {
    private int totalBooks;
    private int totalLibraries;
    private int days;

    private ArrayList<Integer> bookScore;
    private ArrayList<Library> libraries;

    public Operations() {
        this.bookScore = new ArrayList<>();
        this.libraries = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "";
        result += "Total books : " + totalBooks;
        result += "\nTotal libraries : " + totalLibraries;
        result += "\nDays : " + days;
        result += "\n==================================\n";

        for (Integer index : bookScore) {
            result += index.toString() + " ";
        }

        for (Library library : libraries) {
            result += "\n\n";
            result += library.toString();
        }

        return result;
    }

    public void parseInput(String fileName) {
        try {
            int currentLibraryId = 0;
            int flag = 0;
            int cpt = 0;

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));

            while ((line = reader.readLine()) != null) {
                String[] stringArray = line.split(" ");

                switch (cpt) {

                    /* First line case */
                    case(0) :
                        for (String value : stringArray) {
                            switch (flag) {

                                /* Books number*/
                                case (0) :
                                    this.totalBooks = Integer.parseInt(value);
                                    break;

                                /* Librairies number */
                                case (1) :
                                    this.totalLibraries = Integer.parseInt(value);
                                    break;

                                /* Total days */
                                case (2) :
                                    this.days = Integer.parseInt(value);
                                    break;
                            }
                            flag++;
                        }
                        cpt++;
                        flag = 0;
                        break;

                    case(1) :
                        for (String value : stringArray) {
                            this.bookScore.add(Integer.parseInt(value));
                        }
                        cpt++;
                        break;

                    case(2) :
                        Library library = new Library();
                        library.setId(currentLibraryId);

                        for (String value : stringArray) {
                            if (!(value.equals(""))) {
                                switch (flag) {
                                    case (0) :
                                        library.setTotalBooks(Integer.parseInt(value));
                                        flag++;
                                        break;
                                    case (1) :
                                        library.setTime(Integer.parseInt(value));
                                        flag++;
                                        break;
                                    case (2) :
                                        library.setBooksByDay(Integer.parseInt(value));
                                        break;
                                }
                            }
                        }
                        flag = 0;

                        // this.libraries.put(currentLibraryId, library);
                        this.libraries.add(library);

                        cpt++;
                        break;

                    case(3) :
                        for (String value : stringArray) {
                            Book book = new Book(Integer.parseInt(value), this.bookScore.get(Integer.parseInt(value)));
                            this.libraries.get(Integer.valueOf(currentLibraryId)).addBook(book);
                        }

                        currentLibraryId++;
                        cpt--;
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAllRatios() {
        for (Library library : libraries) {
            library.setRatio();
        }
    }

    public void sortLibraries() {
        Collections.sort(this.libraries);
    }

}
