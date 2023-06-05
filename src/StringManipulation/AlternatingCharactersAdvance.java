package StringManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class AlternatingCharactersAdvance {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfQuery = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, numberOfQuery).forEach(query -> {
            try {
                String s = bufferedReader.readLine();

                String result = AlternatingCharactersAdvance.alternatingCharactersAdvance(s);
                System.out.println(result);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private static String alternatingCharactersAdvance(String s) {
        StringBuilder processedString = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                processedString.append(s.charAt(i));
            }
        }
        return processedString.toString();
    }


}
