package TwoPointers;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosestToTarget {

    static int findClosestSum(int[] nums, int target){
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for(int i=0; i<nums.length-2; i++){
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];
                if(Math.abs(currentSum - target) < Math.abs(closestSum - target)){
                    closestSum = currentSum;
                }
                if(currentSum == target){
                    return currentSum;
                } else if (currentSum < target) {
                    left++;
                }else {
                    right--;
                }
            }

        }
        return closestSum;
    }



    public static void main(String[] args) {
       int[] a =  {7,8,9};
       int x = -1;
        System.out.println(findClosestSum(a,x));
    }
}
