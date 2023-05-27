package Basic;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    /**
     * Два низа се наричат анаграми, ако образуват смислена дума чрез пренареждане или
     * разместване на буквите на низа. С други думи, можем да кажем, че два низа са анаграми,
     * ако съдържат едни и същи знаци, но в различен ред.
     * boolean: If  and  are case-insensitive anagrams, return true. Otherwise, return false.
     * асо-оса
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String firstWord = scan.next();
        String secondWord = scan.next();
        scan.close();
        boolean result;
        result = isAnagram(firstWord, secondWord);
        System.out.println((result) ? "Anagrams" : "Not Anagrams");

    }

    static boolean isAnagram(String firstWord, String secondWord) {
        // Complete the function
        boolean status = true;
        if (firstWord.length() != secondWord.length()) {
            status = false;
        } else {
            char[] arrayFirstWord = firstWord.toLowerCase().toCharArray();
            char[] arraySecondWord = secondWord.toLowerCase().toCharArray();
            Arrays.sort(arrayFirstWord);
            Arrays.sort(arraySecondWord);
            status = Arrays.equals(arrayFirstWord, arraySecondWord);
        }
        return status;
    }

}
