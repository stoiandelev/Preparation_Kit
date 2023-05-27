package Basic;

import java.util.Scanner;

public class Palindrome {

    /**
     * Palindrome is word that when we read from begging to end
     * and end to begin is the same
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toLowerCase();
        StringBuilder reversedString = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedString.append(word.charAt(i));
        }

        if (word.equals(reversedString.toString())){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
