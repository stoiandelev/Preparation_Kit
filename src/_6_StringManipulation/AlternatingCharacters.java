package _6_StringManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

//that can be deleted so that the string does not have matching adjacent characters.
//5
//AAAA
//BBBBB
//ABABABAB
//BABABA
//AAABBB

public class AlternatingCharacters {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfQuery = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, numberOfQuery).forEach(query -> {
            try {
                String s = bufferedReader.readLine();

                int result = AlternatingCharacters.alternatingCharacters(s);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


    }

    public static int alternatingCharacters(String s) {

        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            }
        }
        return count;

    }


}
