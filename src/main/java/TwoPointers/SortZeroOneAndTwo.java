package TwoPointers;

import java.util.Arrays;

public class SortZeroOneAndTwo {

    public static void sortedArray(int[] nums){

        int zero=0, one=0, two=0;

        for (int j : nums) {
            if (j == 0) {
                zero++;
            } else if (j == 1) {
                one++;
            } else {
                two++;
            }
        }

        System.out.println("Count of Zero, One & Two :: " + zero + " " + one +" " + two);

        for(int i = 0; i< nums.length; i++){
            if(i < zero){
                nums[i] = 0;
            }
            else if(i >= zero && i < zero + one){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void sortedArrayOptimized(int[] nums){
        int low=0, mid=0, high=nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                mid++;
                low++;
            } else if (nums[mid] == 1) {
                mid++;
            }else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }



    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 3, 5, 4, 1};
        //System.out.println(majorityElement(a));
    }
}
