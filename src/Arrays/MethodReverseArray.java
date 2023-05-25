package Arrays;

import java.util.Arrays;

public class MethodReverseArray {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5, 6, 7}, 2, 5)));
    }


    public static int[] reverse(int[] arr, int begin, int end) {
        while (begin < end) {
            int temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
//            System.out.println(Arrays.toString(arr));
            begin++;
            end--;
        }
        return arr;

    }

}
