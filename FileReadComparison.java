import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileReadComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String filePath = sc.nextLine();

        // FileReader Test
        long startTime = System.nanoTime();
        readUsingFileReader(filePath);
        long endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) / 1e6 + " ms");

        // InputStreamReader Test
        startTime = System.nanoTime();
        readUsingInputStreamReader(filePath);
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1e6 + " ms");
    }

    // Read using FileReader (Character Stream)
    public static void readUsingFileReader(String filePath) {
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            while (br.readLine() != null) { } // Read line by line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read using InputStreamReader (Byte Stream)
    public static void readUsingInputStreamReader(String filePath) {
        try (InputStreamReader isr = new InputStreamReader(Files.newInputStream(Paths.get(filePath)), "UTF-8");
             BufferedReader br = new BufferedReader(isr)) {
            while (br.readLine() != null) { } // Read line by line
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
I/P:
    Enter file path: ./README.md
O/P:
    FileReader Time: 2.0685 ms
    InputStreamReader Time: 54.8503 ms
*/