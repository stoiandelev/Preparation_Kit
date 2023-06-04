package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FraudulentActivityNotifications {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int numberOfDays = Integer.parseInt(firstMultipleInput[0]);
        int numberOfTrailingDays = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = FraudulentActivityNotifications.activityNotifications(expenditure, numberOfTrailingDays);
        System.out.println(result);
    }

    private static int activityNotifications(List<Integer> expenditure, int numberOfTrailingDays) {

        int count = 0;
        int potentialFraud = 0;
        int temporaryIndex = numberOfTrailingDays - 1;

        List<Integer> temporaryList = expenditure
                .subList(count, numberOfTrailingDays)
                .stream()
                .sorted()
                .collect(Collectors.toList());

        for (int i = numberOfTrailingDays; i < expenditure.size(); i++) {

            if (expenditure.get(i) >= median(temporaryList)) {
                potentialFraud++;
            }
            if (Objects.equals(expenditure.get(i), expenditure.get(i - numberOfTrailingDays))) {
                continue;
            }

            int removeIndex = Collections.binarySearch(temporaryList, expenditure.get(i - numberOfTrailingDays));
            temporaryList.remove(removeIndex);

            temporaryIndex = Collections.binarySearch(temporaryList, expenditure.get(i));

            if (temporaryIndex < 0) {
                temporaryIndex = (-1 * temporaryIndex) - 1;
            }

            temporaryList.add(temporaryIndex, expenditure.get(i));

            count++;

        }
        return potentialFraud;
    }

    public static int median(List<Integer> temporaryList) {
        //even
        if (temporaryList.size() % 2 == 0) {
            int firstResult = temporaryList.get((temporaryList.size() / 2) - 1);
            int secondResult = temporaryList.get(temporaryList.size() / 2);
            return firstResult + secondResult;
        //odd
        } else {
            return ((temporaryList.get(temporaryList.size() / 2)) * 2);
        }
    }


}






