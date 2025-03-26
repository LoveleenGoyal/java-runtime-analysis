import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TargetSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get dataset size from user
        System.out.print("Enter the size of large dataset: ");
        int size = sc.nextInt();

        // Generate random dataset
        int[] dataset = generateDataset(size);

        // Get target value from user
        System.out.print("Enter the target value to search: ");
        int target = sc.nextInt();

        // Measure Linear Search Time
        long startTime = System.nanoTime();
        int linearIndex = linearSearch(dataset, target);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;

        // Sort dataset for Binary Search
        Arrays.sort(dataset);

        // Measure Binary Search Time
        startTime = System.nanoTime();
        int binaryIndex = binarySearch(dataset, target);
        endTime = System.nanoTime();
        long binaryTime = endTime - startTime;

        // Display results
        System.out.println("Linear Search: Found at index " + linearIndex + ", Time Taken: " + linearTime / 1e6 + " ms");
        System.out.println("Binary Search: Found at index " + binaryIndex + ", Time Taken: " + binaryTime / 1e6 + " ms");

        sc.close();
    }

    public static int[] generateDataset(int size) {
        Random ran = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {  // Fixed 'n' to 'size'
            data[i] = ran.nextInt(size * 10);
        }
        return data;
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}

/*
I/P:
    Enter the size of large dataset: 100000
    Enter the target value to search: 600
O/P:
    Linear Search: Found at index -1, Time Taken: 3.4651 ms
    Binary Search: Found at index -1, Time Taken: 0.0148 ms
*/