import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int arraysAmount = Integer.parseInt(args[0]);
        ArrayList<ArrayList<Integer>> arrays = createArrays(arraysAmount);

        System.out.println("Arrays before sort:");
        print(arrays);

        sort(arrays);

        System.out.println("\nArrays after sort:");
        print(arrays);
    }

    private static ArrayList<ArrayList<Integer>> createArrays(int n) {
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>(n);

        Random rand = new Random();
        int singleArrayCapacity;

        for (int i = 0; i < n; i++) {
            singleArrayCapacity = rand.nextInt(6) + 5;
            ArrayList<Integer> arr = new ArrayList<>(singleArrayCapacity);

            for (int j = 0; j < singleArrayCapacity; j++) {
                arr.add(rand.nextInt(101));
            }

            arrays.add(arr);
        }

        return arrays;
    }

    private static void print(ArrayList<ArrayList<Integer>> arrays) {
        for (int i = 0; i < arrays.size(); i++) {
            System.out.println("Array #" + i);
            arrays.get(i).forEach(number -> System.out.print(number + " "));
            System.out.println("\n----------------------");
        }

    }

    private static void sort(ArrayList<ArrayList<Integer>> arrays) {
        arrays.forEach(Collections::sort);
        for (int i = 0; i < arrays.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(arrays.get(i));
            }
        }
    }
}
