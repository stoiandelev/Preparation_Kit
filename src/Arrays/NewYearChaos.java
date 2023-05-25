package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewYearChaos {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(7);
        list.add(8);

        int bribes = 0;
        for (int i = list.size(); i > 0; i--) {
            if (i == list.get(i - 1)) {
                continue;
            }
            if (i == list.get(i - 2)) {
                Collections.swap(list, i - 1, i - 2);
                bribes++;
                continue;
            }
            if (i == list.get(i - 3)) {
                Collections.swap(list, i - 3, i - 2);
                Collections.swap(list, i - 2, i - 1);
                bribes += 2;
                continue;
            }
            System.out.println("Too chaotic");
            return;
        }

        System.out.println(bribes);


    }
}
