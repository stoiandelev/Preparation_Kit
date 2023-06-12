package _7_GreedyAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Input Format
 * The first line contains two space-separated integers n (numberOfPreliminaryContests)
 * and k(maximumImportantContestsCanLose),
 * the number of preliminary contests
 * and the maximum number of important contests Lena can lose.
 * Each of the next n (numberOfPreliminaryContests) lines
 * contains two space-separated integers, L(i) and T(i) ,
 * the contest's luck balance and its importance rating.
 */

//6 3
//5 1
//2 1
//1 1
//8 1
//10 0
//5 0

public class LuckBalance {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader
                .readLine()
                .replaceAll("\\s+$", "").split(" ");

        int numberOfPreliminaryContests = Integer.parseInt(firstMultipleInput[0]);
        int maximumImportantContestsCanLose = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> contests = new ArrayList<>();

        IntStream.range(0, numberOfPreliminaryContests).forEach(i -> {
            try {
                contests.add(
                        Stream.of(bufferedReader.readLine()
                                        .replaceAll("\\s+$", "")
                                        .split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        int result = LuckBalance.luckBalance(maximumImportantContestsCanLose, contests);
        System.out.println(result);
    }


    private static int luckBalance(int maximumImportantContestsCanLose, List<List<Integer>> contests) {

        List<Integer> importantContests = new ArrayList<>();
        List<Integer> nonImportantContests = new ArrayList<>();

        for (List<Integer> contest : contests) {
            if (contest.get(1) == 1) {
                importantContests.add(contest.get(0));
            } else {
                nonImportantContests.add(contest.get(0));
            }
        }

        List<Integer> sortedImportnant = importantContests.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (maximumImportantContestsCanLose >= sortedImportnant.size()) {
            maximumImportantContestsCanLose = sortedImportnant.size();
        }

        int luck = IntStream.range(0, maximumImportantContestsCanLose).map(sortedImportnant::get).sum();
        luck += IntStream.range(0, nonImportantContests.size()).map(nonImportantContests::get).sum();

        if (maximumImportantContestsCanLose <= sortedImportnant.size()) {
            luck -= IntStream.range(maximumImportantContestsCanLose, sortedImportnant.size()).map(sortedImportnant::get).sum();
        }
        return luck;
    }
}



