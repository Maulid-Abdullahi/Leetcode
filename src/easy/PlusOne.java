package easy;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > -1; --i) {
            if (digits[i] != 9) {
                digits[i] += 1;
                for (int j = i + 1; j < digits.length; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        PlusOne plusOne = new PlusOne();
        System.out.println("Original array: " + Arrays.toString(nums));
        System.out.println("Array of digits: " + Arrays.toString(plusOne.plusOne(nums)));
    }
}
