package _6_StringManipulation;

import java.util.Scanner;

/**
 * A string is said to be a special string if either of two conditions is met:
 * All the characters are the same, e.g., aaa.
 * All characters except the middle one are the same, e.g., aadaa.
 * 5
 * asasd
 */

public class SpecialStringAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();
        long result = substrCount(length, s);
        System.out.println(result);
    }

    private static long substrCount(int length, String s) {
        long count = length;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (charArray[i] == charArray[j]) {
                    count++;
                }
                if (charArray[i] != charArray[j]) {
                    int lastIndex = j * 2 - i;
                    if (lastIndex < length && s.substring(i, j).equals(s.substring(j + 1, lastIndex + 1))) {
                        count++;
                    }
                    break;
                }
            }
        }

        return count;

    }
}
