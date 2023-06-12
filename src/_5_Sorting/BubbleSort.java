package _5_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sizeOfArray = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        BubbleSort.countSwaps(a);

        bufferedReader.close();

    }

    private static void countSwaps(List<Integer> listToSort) {

        int n = listToSort.size();
        int temp;
        long swaps = 0;
        boolean swaped;

        for (int i = 0; i < n; i++) {
            swaped = false;
            for (int j = 0; j < n - i - 1; j++) {

                if (listToSort.get(j) > listToSort.get(j + 1)) {
                    temp = listToSort.get(j);
                    listToSort.set(j, listToSort.get(j + 1));
                    listToSort.set(j + 1, temp);
                    swaped = true;
                    swaps++;
                }
            }
            if (!swaped) break;
        }
        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + listToSort.get(0));
        System.out.println("Last Element: " + listToSort.get(n - 1));
    }
}

