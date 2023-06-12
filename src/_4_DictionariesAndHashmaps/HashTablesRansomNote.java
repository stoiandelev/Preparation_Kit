package _4_DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;


public class HashTablesRansomNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader
                .readLine()
                .replaceAll("\\s+$", "")
                .split(" ");

        int numberOfWordInMagazine = Integer.parseInt(firstMultipleInput[0]);
        int numberOfWordInNote = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = new java.util.ArrayList<>(Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" "))
                .toList());

        List<String> note = Stream.of(bufferedReader.readLine()
                        .replaceAll("\\s+$", "")
                        .split(" "))
                .toList();

        bufferedReader.close();



        for (String word : note) {
            if (!magazine.contains(word)) {
                System.out.println("No");
                return;
            } else {
                magazine.remove(word);
            }
        }
        System.out.println("Yes");


    }

}


