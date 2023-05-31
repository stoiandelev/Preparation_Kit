package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Given a list of toy prices and an amount to spend,
// determine the maximum number of gifts he can buy.

//7 50
//1 12 5 111 200 1000 10

public class MarkAndToys {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader
                .readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int numberOfToys = Integer.parseInt(firstMultipleInput[0]);
        int spendMoney = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = MarkAndToys.maximumToys(prices, spendMoney);
        System.out.println(result);

    }

    private static int maximumToys(List<Integer> prices, int spendMoney) {
        int countToysToBuy = 0;
        Collections.sort(prices);

        for (Integer price : prices) {
            if (price < spendMoney) {
                spendMoney -= price;
                countToysToBuy++;
            } else {
                break;
            }
        }
        return countToysToBuy;
    }
}
