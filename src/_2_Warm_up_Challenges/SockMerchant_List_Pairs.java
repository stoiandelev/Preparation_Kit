package _2_Warm_up_Challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * There is a large pile of socks that must be paired by color.
 * Given an array of integers representing the color of each sock,
 * determine how many pairs of socks with matching colors there are.
 */

public class SockMerchant_List_Pairs {
    public static void main(String[] args) {
        int n = 9;
        List<Integer> ar = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int sockPairs = countSockPairs(n, ar);
        System.out.println(sockPairs);

    }

    public static int countSockPairs(int n, List<Integer> ar) {
        HashMap<Integer, Integer> colorCount = new HashMap<>();
        int pairCount = 0;
        // Count the frequency of each color
        for (Integer color : ar) {
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
        }
        // Count the number of pairs for each color
        for (Integer count : colorCount.values()) {
            int pairs = count / 2;
            pairCount += pairs;
        }
        return pairCount;
    }
}
