import java.util.Scanner;

public class FibonacciComputationComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the fibonacci series: ");
        int n = sc.nextInt();

        sc.close();

        // Calculate recursive time
        long startTime = System.nanoTime();
        int recursiveResult = fibonacciRecursive(n);
        long endTime = System.nanoTime();
        long recursiveTime = endTime - startTime;

        // Calculate iterative time
        startTime = System.nanoTime();
        int iterativeResult = fibonacciIterative(n);
        endTime = System.nanoTime();
        long iterativeTime = endTime - startTime;

        System.out.println("Fibonacci Number (N): " + n);
        System.out.println("Recursive Result: " + recursiveResult + " | Time: " + recursiveTime / 1_000_000.0 + " ms");
        System.out.println("Iterative Result: " + iterativeResult + " | Time: " + iterativeTime / 1_000_000.0 + " ms");
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

}

/*
I/P:
    Enter the size of the fibonacci series: 30
O/P:
    Fibonacci Number (N): 30
    Recursive Result: 832040 | Time: 12.2063 ms
    Iterative Result: 832040 | Time: 0.0282 ms
*/