package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
public class MaxSumSubArrayNoDuplicates {

    static long maxSumSubArray(int[] nums, int k){
       // In order to track distinct elements in the subarray we will use Map
        Map<Integer, Integer> map = new HashMap<>();

        // we need two variables one maxSum it will hold the maxSum value of distinct subarrays only
        long maxSum = 0;

        //windowSum = to keep track of the current window sum
        int windowSum = 0;

        //lets find the base sum of the firstWindow
        for(int i=0; i< k; i++){
            windowSum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        //Check if the subarray were distinct, for all unique keys map size will be k
        if(map.size() == k) maxSum = windowSum;

        int i=1;
        //since we are tracking the high end of the window using i+k-1 we need to make sure i remains inside the valid window
        while( i <= nums.length - k){
            // we need this variable to track the new window sum after sliding
            int sum = 0;

            //only remove the from map if the frquency is 0
            if(map.containsKey(nums[i-1])){
                int count = map.get(nums[i-1]);
                if(count > 1) {
                    map.put(nums[i-1], count - 1);
                }else{
                    map.remove(nums[i-1]);
                }
            }

            map.put(nums[i+k-1], map.getOrDefault(nums[i+k-1], 0)+1);

            //check current window sum by removing the first element of old window and adding the new element of the new window.
            sum = windowSum - nums[i-1] + nums[i+k-1];

            //Make sure to update the window sum
            windowSum = sum;

            //check if the subarray was distinct
            if(map.size() == k){
                maxSum = Math.max(sum, maxSum);
            }
            //move the window position
            i++;
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int [] a = {3,2,3,1};
        int k = 3;
        System.out.println(maxSumSubArray(a,k));

    }
}
