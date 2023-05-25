package Arrays;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {

        // 4 rotation
        //[1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]

        // we accept array and how many times we want to rotate

        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        int lengthOfArray = 5;
        int d_rotation_time = 4;

        for (int i = 0; i < d_rotation_time; i++) {
            if (!arrayList.isEmpty()) {
                int firstElement = arrayList.get(0);
                arrayList.remove(0);
                arrayList.add(firstElement);
            }
        }
        System.out.println(arrayList);
    }
}
