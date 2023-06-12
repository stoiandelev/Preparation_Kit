package _2_Warm_up_Challenges;

public class Counting_Valleys {

    public static void main(String[] args) {
        //U -> up
        //D -> down
        int steps = 8;
        String path = "DDUUDDUDUUUD";

        int result = 0;
        int seaLevel = 0;
        for (int i = 0, n = path.length(); i < n; i++) {
            char c = path.charAt(i);

            if (c == 'U') {
                seaLevel++;
                if (seaLevel == 0) {
                    result++;
                }
            } else {
                seaLevel--;
            }
        }
        System.out.println(result);
    }
}
