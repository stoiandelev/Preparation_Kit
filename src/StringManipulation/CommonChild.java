package StringManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * A string is said to be a child of another string
 * if it can be formed by deleting 0 or more characters from the other string.
 * Letters cannot be rearranged - some order
 * Given two strings of equal length, what's the longest string that can be constructed
 * such that it is a child of both?
 * LCS -> Longest Common Subsequence
 * HARRY
 * SALLY
 */

public class CommonChild {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bufferedReader.readLine().trim();
        String s2 = bufferedReader.readLine().trim();
        int result = CommonChild.commonChild(s1, s2);
        System.out.println(result);

    }

    private static int commonChild(String s1, String s2) {

        int lengthString1 = s1.length();
        int lengthString2 = s2.length();

        int[][] matrix = new int[lengthString1 + 1][lengthString2 + 1];

        for (int i = lengthString1 - 1; i >= 0; i--) {
            for (int j = lengthString2 - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {
                    matrix[i][j] = 1 + matrix[i + 1][j + 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i + 1][j], matrix[i][j + 1]);
                }
            }
        }

        return matrix[0][0];


    }
}
