package _3_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//5 3
//1 2 100
//2 5 100
//3 4 100

/**
 * The first line contains two space-separated integers sizeOfArray and numberOfOperation,
 * the size of the array and the number of operations.
 * Each of the next m lines contains three space-separated integers a, b and k,
 * the left index, right index and summand.
 */

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader
                .readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int sizeOfArray = Integer.parseInt(firstMultipleInput[0]);
        int numberOfOperation = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, numberOfOperation).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        long[] arr = new long[sizeOfArray + 1];
        for (int i = 0; i < queries.size(); i++) {

            int from = queries.get(i).get(0) - 1;
            int to = queries.get(i).get(1);
            int toAdd = queries.get(i).get(2);

            arr[from] += toAdd;
            arr[to] -= toAdd;

        }
        long max = 0;
        int sum = 0;
        for (long j : arr) {
            sum += j;
            max = Math.max(sum, max);
        }

        System.out.println(max);

    }
}