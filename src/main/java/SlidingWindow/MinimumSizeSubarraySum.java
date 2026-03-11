package SlidingWindow;

public class MinimumSizeSubarraySum {

    static int minSubArrayLength(int[] nums, int target){

        //low point of window
        int low=0;
        //high point of window
        int high=0;
        //store the minimum length
        int result = Integer.MAX_VALUE;
        //sum of the subarray
        int sum=0;

        while(high< nums.length){
            sum += nums[high];
            while(sum >= target){

                //calculate the current length of the subarray
                int len = high - low + 1;
                result = Math.min(len,result);
                //start decreasing the sum by removing from left of the subarray
                sum = sum - nums[low];
                low++;
            }
            high++;
        }

        return result==Integer.MAX_VALUE ? 0:result;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,2,4,3};
        int target = 70000;
        System.out.println(minSubArrayLength(a,target));
    }
}
