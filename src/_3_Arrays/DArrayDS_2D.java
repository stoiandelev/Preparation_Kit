package _3_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DArrayDS_2D {

    public static void main(String[] args) throws IOException {

        //6x6
        //1 1 1 0 0 0
        //0 1 0 0 0 0
        //1 1 1 0 0 0
        //0 0 2 4 4 0
        //0 0 0 2 0 0
        //0 0 1 2 4 0

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> array = new ArrayList<>();

        //fill matrix(list)
        IntStream.range(0, 6).forEach(i -> {
            try {
                array.add(
                        Stream
                                .of(bufferedReader.readLine()
                                        .replaceAll("\\s+$", "")
                                        .split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int arrRow = 0; arrRow < array.size() - 2; arrRow++) {
            for (int arrColumn = 0; arrColumn < array.get(arrRow).size() - 2; arrColumn++) {

                int sum1 = array.get(arrRow).get(arrColumn);
                int sum2 = array.get(arrRow).get(arrColumn + 1);
                int sum3 = array.get(arrRow).get(arrColumn + 2);

                int sum4 = array.get(arrRow + 1).get(arrColumn + 1);

                int sum5 = array.get(arrRow + 2).get(arrColumn);
                int sum6 = array.get(arrRow + 2).get(arrColumn + 1);
                int sum7 = array.get(arrRow + 2).get(arrColumn + 2);

                sum = sum1 + sum2 + sum3 + sum4 + sum5 + sum6 + sum7;

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println(maxSum);

        bufferedReader.close();
    }

}

