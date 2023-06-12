package _4_DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * You are given an array, and you need to find number of tripets of indices (i, j, k)
 * such that the elements at those indices are in geometric progression for a given
 * common ratio "r" and i < j < k.
 */

//geometric progression

/**
 * 4 2
 * 1 2 2 4
 * 1*2 = 2, 2*2 = 4;   1*2 = 2, 2*2 =4;  index -> (0, 1, 3) and (0, 2, 3)
 */

//6 3
//1 3 9 9 27 81

public class CountTriplets {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int sizeOfArray = Integer.parseInt(nr[0]);

        long ration = Long.parseLong(nr[1]);

        List<Long> array = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .toList();

        long answer = countTriplets(array, ration);
        System.out.println(answer);

        bufferedReader.close();

    }

    private static long countTriplets(List<Long> array, long ratio) {
        HashMap<Long, Long> right = new HashMap<>();
        HashMap<Long, Long> left = new HashMap<>();

        for (Long number : array) {
            right.put(number, right.getOrDefault(number, 0L) + 1);
        }

        long tripletsCounter = 0;

        for (Long number : array) {
            if (right.getOrDefault(number, 0L) > 0) {
                right.put(number, right.get(number) - 1);
            }
            if (number % ratio == 0) {
                long rightResult = right.getOrDefault(number * ratio, 0L);
                long leftResult = left.getOrDefault(number / ratio, 0L);

                long currentResult = rightResult * leftResult;

                tripletsCounter = tripletsCounter + currentResult;
            }
            left.put(number, left.getOrDefault(number, 0L) + 1);
        }

        return tripletsCounter;
    }
}

