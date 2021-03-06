package easy;

public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        for (int i = 0; i<nums.length; i++){
            for(int j = i + 1 ; j<nums.length; j++){
                if( nums[j] == target - nums[i]){
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int number[] = {2,7,11,15};
        int[] checkTwoSum = new TwoSum().twoSum(number,9);

        System.out.println("indices of the two numbers such that they add up to target " + checkTwoSum);
    }
}
