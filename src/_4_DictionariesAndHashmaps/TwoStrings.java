package _4_DictionariesAndHashmaps;

import java.io.*;
import java.util.HashSet;
import java.util.stream.IntStream;


//2
//hello
//world
//hi
//world

//Given two strings, determine if they share a common substring.
// A substring may be as small as one character.

public class TwoStrings {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCase = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, numberOfTestCase).forEach(qItr -> {
            try {
                String string1 = bufferedReader.readLine();
                String string2 = bufferedReader.readLine();
                String result = TwoStrings.twoStrings(string1, string2);
                System.out.println(result);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }


    public static String twoStrings(String string1, String string2) {

        HashSet<Character> rootHashSet = new HashSet<>();
        HashSet<Character> hashSet1 = new HashSet<>();
        HashSet<Character> hashSet2 = new HashSet<>();

        string1.chars().forEach(c -> {
            rootHashSet.add((char) c);
            hashSet1.add((char) c);
        });
        string2.chars().forEach(c -> {
            rootHashSet.add((char) c);
            hashSet2.add((char) c);
        });

        if (hashSet1.size() + hashSet2.size() != rootHashSet.size()) {
            return "YES";
        }
        return "NO";

    }
}