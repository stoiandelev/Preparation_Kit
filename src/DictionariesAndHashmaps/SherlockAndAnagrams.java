package DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

// The number of pairs of substrings of the string that are anagrams of each other.

/**
 * Two strings are anagrams of each other if the letters of one string
 * can be rearranged to form the other string. Given a string, find
 * the number of pairs of substrings of the string that are anagrams of each other.
 */

public class SherlockAndAnagrams {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfQueries = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, numberOfQueries).forEach(query -> {
            try {
                String s = bufferedReader.readLine();
                int result = SherlockAndAnagrams.sherlockAndAnagrams(s);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();


    }

    private static int sherlockAndAnagrams(String s) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        // Iterate over all possible substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {

                String substring = s.substring(i, j);
                char[] charArray = substring.toCharArray();
                Arrays.sort(charArray);  // Sort the characters of the substring

                // Convert the sorted char array back to a string
                String sortedSubstr = new String(charArray);

                // Get the count of anagrams found so far for the sorted substring
                int prevCount = map.getOrDefault(sortedSubstr, 0);

                // Update the count and put it back into the map
                map.put(sortedSubstr, prevCount + 1);

                count += prevCount;
            }
        }

        return count;

    }
}
