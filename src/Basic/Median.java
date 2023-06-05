package Basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The median of a list of numbers can be found by first sorting the numbers ascending.
 * If there is an odd number of values, the middle one is picked.
 * If there is an even number of values, the median is then defined to be the average of the two middle values.
 */

public class Median {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(30);


        System.out.println(median(list));
    }

    public static double median(List<Integer> list) {
        Collections.sort(list);
        int size = list.size();

        //even
        if (size % 2 == 0) {
            int firstResult = list.get(size / 2 - 1);
            int secondResult = list.get(size / 2);
            return (firstResult + secondResult) / 2.0;
        //odd
        } else {
            return list.get(size / 2);
        }
    }
}

