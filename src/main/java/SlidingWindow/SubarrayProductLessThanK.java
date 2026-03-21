package SlidingWindow;

public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        int subArrays = 0;
        int low=0, product=1;

        for(int high=0; high<nums.length; high++){
            product *= nums[high];

            while (product >= k && low <= high){
                product = product/nums[low];
                low++;
            }
            subArrays += high-low+1;
        }


        return subArrays;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3};
        int k = 0;
        System.out.println(numSubarrayProductLessThanK(a, k));
    }
}
