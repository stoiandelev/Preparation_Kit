package _2_Warm_up_Challenges;

import java.util.ArrayList;
import java.util.List;

public class JumpingOnTheClouds {

    public static void main(String[] args) {

        // 0 is safe
        // 1 is must avoid
        // Print the minimum number of jumps needed to win the game.

        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(0);
        list.add(1);
        list.add(0);

        int i = 0;
        int jumpCount = 0;

        //0-0-1-0-0-1-0
        while (i < list.size() - 1) {
            if (list.get(i) == 0) {
                if (i + 2 < list.size() && list.get(i + 2) == 0) {
                    i += 2;
                } else {
                    i += 1;
                }
            }
            jumpCount++;
        }
        System.out.println(jumpCount);
    }
    // with ternary operator
    // i = (i + 2 < list.size() && list.get(i + 2) == 0) ? i + 2 : i + 1;

}

