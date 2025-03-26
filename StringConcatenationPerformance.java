import java.util.Scanner;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Take user input for number of strings
        System.out.print("Enter number of concatenations: ");
        int n = sc.nextInt();

        sc.close();

        // Calculate performance
        long stringTime = testStringConcatenation(n);
        long stringBuilderTime = testStringBuilder(n);
        long stringBufferTime = testStringBuffer(n);


        System.out.println("Number of concatenations: " + n);
        System.out.println("String (O(N^2)) Time: " + stringTime / 1_000_000.0 + " ms");
        System.out.println("StringBuilder (O(N)) Time: " + stringBuilderTime / 1_000_000.0 + " ms");
        System.out.println("StringBuffer (O(N)) Time: " + stringBufferTime / 1_000_000.0 + " ms");

    }

    // String Concatenation using Immutable String
    public static long testStringConcatenation(int n) {
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            // Creates a new object every time (inefficient)
            str += "a";
        }
        return System.nanoTime() - startTime;
    }

    // String Concatenation using StringBuilder
    public static long testStringBuilder(int n) {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return System.nanoTime() - startTime;
    }

    // String Concatenation using StringBuffer
    public static long testStringBuffer(int n) {
        long startTime = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        return System.nanoTime() - startTime;
    }
}

/*
I/P:
    Enter number of concatenations: 4
O/P:
    Number of concatenations: 4
    String (O(N^2)) Time: 0.1781 ms
    StringBuilder (O(N)) Time: 0.0024 ms
    StringBuffer (O(N)) Time: 0.065 ms
*/