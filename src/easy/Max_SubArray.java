package easy;

public class Max_SubArray {
        public int maxSubArray(int[] nums) {
            int result = nums[0];
            int[] sum =  new int[nums.length];
            sum[0] = nums[0];

            for(int i=1; i<nums.length; i++){
                sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
                result = Math.max(result, sum[i]);
            }

            return result;
        }


    public static void main(String[] args) {
        Max_SubArray max_subArray = new Max_SubArray();
        int[] arr = {-2,4,-3,2};
        System.out.println(max_subArray.maxSubArray(arr));
    }
}
