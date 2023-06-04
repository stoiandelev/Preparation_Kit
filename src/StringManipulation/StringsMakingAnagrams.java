package StringManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//wo strings are anagrams of each other if the first string's
// letters can be rearranged to form the second string.
// In other words, both strings must contain the same exact letters in the same exact frequency.

//how many delete is necessary for two words is doing anagrams.

public class StringsMakingAnagrams {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String a = bufferedReader.readLine();
        String b = bufferedReader.readLine();

        int res = StringsMakingAnagrams.makeAnagram(a, b);
        System.out.println(res);
    }

    private static int makeAnagram(String a, String b) {
        String aDublicate = a;
        String bDublicate = b;

        for (char letter : a.toCharArray()) {
            bDublicate = bDublicate.replaceFirst(String.valueOf(letter), "");
        }

        for (char letter : b.toCharArray()) {
            aDublicate = aDublicate.replaceFirst(String.valueOf(letter), "");
        }

        return aDublicate.length() + bDublicate.length();
    }
}
