package TwoPointers;

import java.util.Arrays;

public class SortZeroOneAndTwo {

    public static void sort012BruteForce(int[] nums){

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
            else if(i < zero+one){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void sortedArrayOptimized(int[] arr){
        int low=0, mid=0, high=arr.length-1;

        while(mid <= high){

            //if mid is 1 we will not do anything just move on
            if(arr[mid]==1){
                mid++;
            } else if (arr[mid]==0) {
                //we will swap with low, low is responsible for 0s
                int swap = arr[mid];
                arr[mid] = arr[low];
                arr[low] = swap;
                low++;
                mid++;
            }else{
                //when mid is 2 we will swap with high but we dont know what high will send us so we can simply move high keep mid as it is
                int swap = arr[mid];
                arr[mid] = arr[high];
                arr[high] = swap;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }



    public static void main(String[] args) {
        int[] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012BruteForce(a);
    }
}
