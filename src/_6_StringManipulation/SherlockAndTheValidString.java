package _6_StringManipulation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Sherlock considers a string to be valid if all characters of the string appear
 * the same number of times. It is also valid if he can remove just 1 character at 1 index in
 * the string, and the remaining characters will occur the same number of times.
 * not valid - abccc
 * valid - abc
 */

public class SherlockAndTheValidString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String string = bufferedReader.readLine();

        String result = SherlockAndTheValidString.isValid(string);
        System.out.println(result);

    }

    private static String isValid(String s) {

        HashMap<Character, Integer> letterCountMap = new HashMap<>();
        HashMap<Integer, Integer> occurrenceMap = new HashMap<>();

        // count letter
        for (Character ch : s.toCharArray()) {
            letterCountMap.put(ch, letterCountMap.getOrDefault(ch, 0) + 1);
        }

        // count of occurrences of the occurrences of the letter
        for (Map.Entry<Character, Integer> entry : letterCountMap.entrySet()) {
            occurrenceMap
                    .put(entry.getValue(), occurrenceMap.getOrDefault(entry.getValue(), 0) + 1);
        }

        // if all equal
        if (occurrenceMap.size() == 1)
            return "YES";

        // find the largest count & smallest count
        // don't really need to keep track of smallest & largest
        // only need to store the 2 key value into variable for comparing later
        int largest_key = Integer.MIN_VALUE;
        int smallest_key = Integer.MAX_VALUE;
        int largest_value = 0;
        int smallest_value = 0;
        for (Map.Entry<Integer, Integer> entry : occurrenceMap.entrySet()) {
            if (entry.getValue() > largest_key) {
                largest_key = entry.getKey();
                largest_value = entry.getValue();
            }
            if (entry.getValue() < smallest_key) {
                smallest_key = entry.getKey();
                smallest_value = entry.getValue();
            }
        }

        // System.out.println("count map: " + letterCountMap);
        // System.out.println("occ map: " + occurrenceMap);
        // System.out.println("largest: " + largest_key);
        // System.out.println("smallest: " + smallest_key);

        if (occurrenceMap.size() == 2) {
            if (occurrenceMap.get(smallest_key) == 1 || occurrenceMap.get(largest_key) == 1)
                if (smallest_key == 1 || largest_key == 1)
                    return "YES";
                else if (Math.abs(smallest_key - largest_key) == 1)
                    return "YES";
        }

        return "NO";
    }
}
