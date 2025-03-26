import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

public class DataStructuresComparison {
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
        boolean linearIndex = linearSearch(dataset, target);
        long endTime = System.nanoTime();
        long linearTime = endTime - startTime;
        System.out.println("Linear Search Time: " + linearTime / 1_000_000 + " ms");

        // Measure hashset search time
        startTime = System.nanoTime();
        boolean hashSetFound = hashSetSearch(dataset, target);
        endTime = System.nanoTime();
        long hashSetTime = endTime - startTime;
        System.out.println("HashSet Search Time: " + hashSetTime / 1_000_000 + " ms");

        // Measure treeSet search time
        startTime = System.nanoTime();
        boolean treeSetFound = treeSetSearch(dataset, target);
        endTime = System.nanoTime();
        long treeSetTime = endTime - startTime;
        System.out.println("TreeSet Search Time: " + treeSetTime / 1_000_000 + " ms");
    }

    public static int[] generateDataset(int size) {
        Random ran = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {  // Fixed 'n' to 'size'
            data[i] = ran.nextInt(size * 10);
        }
        return data;
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int j : arr) {
            if (j == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean hashSetSearch(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : arr) {
            hashSet.add(num);
        }
        return hashSet.contains(target);
    }

    public static boolean treeSetSearch(int[] arr, int target) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : arr) {
            treeSet.add(num);
        }
        return treeSet.contains(target);
    }
}
/*
I/P:
    Enter the size of large dataset: 10000
    Enter the target value to search: 37746
O/P:
    Linear Search Time: 0 ms
    HashSet Search Time: 12 ms
    TreeSet Search Time: 24 ms
*/