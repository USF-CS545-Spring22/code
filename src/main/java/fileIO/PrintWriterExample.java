package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class PrintWriterExample {
    public static void main(String[] args) {

        File file = new File ("newFile.txt");
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter (file);
            printWriter.println ("hello");
            if (printWriter != null)
                printWriter.close ();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file.");
        }

    }
}
