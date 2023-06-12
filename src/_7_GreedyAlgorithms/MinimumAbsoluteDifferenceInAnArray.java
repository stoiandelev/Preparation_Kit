package _7_GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The absolute difference is the positive difference between two values a and b,
 * is written |a-b| or |b-a| and they are equal. If a = 3 and b = 2, |3 - 2| = 1.
 * Given an array of integers,
 * find the minimum absolute difference between any two elements in the array.
 * 3
 * 3 -7 0
 * 5
 * 1 -3 71 68 17
 */

import static java.util.stream.Collectors.toList;

public class MinimumAbsoluteDifferenceInAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int sizeOfArray = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = MinimumAbsoluteDifferenceInAnArray.minimumAbsoluteDifference(arr);


    }

    private static int minimumAbsoluteDifference(List<Integer> arr) {
        List<Integer> sortedList = arr.stream().sorted().collect(Collectors.toList());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < sortedList.size() - 1; i++) {
            int diff = Math.abs(sortedList.get(i) - sortedList.get(i + 1));
            if (diff < min) {
                min = diff;
            }
        }
        return min;


//        List<Integer> sortedList = arr.stream().sorted().collect(Collectors.toList());
//        return IntStream.range(0, arr.size() - 1)
//                .map(i -> Math.abs(sortedList.get(i) - sortedList.get(i + 1)))
//                .min()
//                .orElse(Integer.MAX_VALUE);

    }
}
