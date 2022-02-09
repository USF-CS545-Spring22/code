package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class PrintWriterExample {
    public static void main(String[] args) {

        File file = new File ("newFile.txt");
        try (PrintWriter printWriter = new PrintWriter (file)) {
            printWriter.println ("hello");

        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file.");
        }

    }
}
