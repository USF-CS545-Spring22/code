package fileIO;

import java.io.*;

public class BufferedReaderExample {

    public static void main(String[] args) {
        try (FileReader f = new FileReader("file1.txt");
             BufferedReader br = new BufferedReader(f)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            System.out.println("No such file");
        }
    }

}
