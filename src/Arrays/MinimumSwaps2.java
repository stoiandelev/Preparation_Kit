package Arrays;

public class MinimumSwaps2 {

    public static void main(String[] args) {

        //without any duplicates
        //You are allowed to swap any two elements
        //Find the minimum number of swaps required to sort the array in ascending order.

        int[] arr = new int[]{7, 1, 3, 2, 4, 6, 6};
        System.out.println(minimumSwaps(arr));
    }

    static int minimumSwaps(int[] arr) {
        int numSwaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == i + 1) {
                        //swap positions
                        arr[i] = arr[i] + arr[j];
                        arr[j] = arr[i] - arr[j];
                        arr[i] = arr[i] - arr[j];
                        numSwaps++;
                    }
                }
            }
        }
        return numSwaps;
    }

}
