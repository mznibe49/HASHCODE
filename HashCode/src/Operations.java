import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Operations {
    private int totalBooks;
    private int totalLibraries;
    private int days;

    private ArrayList<Integer> bookScore;
    private ArrayList<Integer> bookByLibrary;

    public Operations() {
        this.bookScore = null;
        this.bookByLibrary = null;
    }

    private void parseInput(String fileName) {
        try {
            int cpt = 0;

            String line;
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));

            while ((line = reader.readLine()) != null) {
                switch (cpt) {
                    case (0) :

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
