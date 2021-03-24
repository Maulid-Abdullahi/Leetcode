package easy;

import java.util.Arrays;

public class InsertPosition {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);

        if (index < 0) {
            index = -index - 1;
        }

        return index;
    }

    public static void main(String[] args) {
        InsertPosition insertPosition = new InsertPosition();
        int nums[] = {1,2,3,8,5,6};

        System.out.println(insertPosition.searchInsert(nums,4 ));
    }
}
