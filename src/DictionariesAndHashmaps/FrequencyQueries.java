package DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//10        8
//1 3       1 5
//2 3       1 6
//3 2       3 2
//1 4       1 10
//1 5       1 10
//1 5       1 6
//1 4       2 5
//3 2       3 2
//2 4
//3 2

/**
 * You are given "numberOfQueries" queries. Each query is of the form two integers described below:
 * 1 ->  Insert x in your data structure.
 * 2 -> Delete one occurrence of y from your data structure, if present.
 * 3-> Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.
 */


public class FrequencyQueries {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfQueries = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, numberOfQueries).forEach(q -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "")
                                        .split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);
        for (Integer num : ans) {
            System.out.println(num);
        }


    }

    private static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> counts = new LinkedHashMap<>();

        for (List<Integer> query : queries) {

            Integer operation = query.get(0);
            Integer value = query.get(1);
            Integer current = counts.getOrDefault(value, 0);

            if (operation == 1) {
                counts.put(value, current + 1);
            } else if (operation == 2) {
                if (current > 0)
                    counts.put(value, current - 1);
            } else if (operation == 3) {
                boolean count = counts.containsValue(value);
                result.add(count ? 1 : 0);
            }
        }

        return result;
    }
}
