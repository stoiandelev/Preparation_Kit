package _5_Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

//2
//5
//1 1 1 2 2
//5
//2 1 3 1 2

public class MergeSortCountingInversions {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = MergeSortCountingInversions.countInversions(arr);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

    }

    private static long countInversions(List<Integer> arr) {
        long swap = 0;
        swap = mergeSort(arr);
        System.out.println(swap);
        return swap;


    }

    public static long mergeSort(List<Integer> inputArr) {

        // Creating a left and Right Array
        List<Integer> leftArr = new ArrayList<>();
        List<Integer> rightArr = new ArrayList<>();

        //The count for the number of inversions
        long count = 0;

        //If the array is less than 2 which means that it is either empty or has one element in it. It will stop the recursion
        if (inputArr.size() < 2) {
            return count;
        }

        //The length of the left array (Half of the entire array)
        int lengthen = inputArr.size() / 2;
        //populating the left array
        for (int i = 0; i < lengthen; i++) {
            leftArr.add(inputArr.get(i));
        }
        //Populating the right array which is the other half of the initial unsorted array
        for (int i = lengthen; i < inputArr.size(); i++) {
            rightArr.add(inputArr.get(i));
        }

        //calling the method again recursively until above if statement is met
        // and adding the number of inversions the sort() functions returns
        count += mergeSort(leftArr);

        count += mergeSort(rightArr);

        // Sorts the left and right array and gives the number of inversions possible
        count += sort(leftArr, rightArr, inputArr);

        return count;
    }

    private static long sort(List<Integer> leftArr, List<Integer> rightArr, List<Integer> inputArr) {
        int i = 0, j = 0, k = 0;
        long swap = 0;
        while (i < leftArr.size() && j < rightArr.size()) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                inputArr.set(k, leftArr.get(i));

                i++;
            } else {
                inputArr.set(k, rightArr.get(j));
                //the number of inversions which is how many elements are to the right of the array in the left.
                // Since the two arrays are already sorted if the element on the right array is smaller than the left
                // Than it must also be smaller than all other elements to the right of the current i element in the left Array.
                swap = swap + (leftArr.size() - i);
                j++;
            }
            k++;
        }

        while (i < leftArr.size()) {
            inputArr.set(k, leftArr.get(i));
            i++;
            k++;
        }

        while (j < rightArr.size()) {
            inputArr.set(k, rightArr.get(j));
            j++;
            k++;
        }
        return swap;

    }
}

