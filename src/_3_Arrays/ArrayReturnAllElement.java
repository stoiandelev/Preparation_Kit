package _3_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayReturnAllElement {
    //write method, that takes two integer Array like arguments and return
    //and return all element in arr1, that not present in arr2

    public static void main(String[] args) {

        int[] ar1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] ar2 = {4, 5, 6, 7, 5};

        List<Integer> result = newArray(ar1, ar2);
        System.out.println(result);

    }

    public static List<Integer> newArray(int[] arrayOne, int[] arrayTwo) {
        List<Integer> finalList = new ArrayList<>();
        String checker = Arrays.toString(arrayTwo);
        for (int numberInArrayOne : arrayOne) {
            if (!checker.contains(Integer.toString(numberInArrayOne))) {
                finalList.add(numberInArrayOne);
            }
        }
        return finalList;

    }


}
