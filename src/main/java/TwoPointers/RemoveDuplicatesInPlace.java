package TwoPointers;

import java.util.Arrays;

//Do not use Extra space
//Time Complexity O(N)
//Space Complexity O(1)
public class RemoveDuplicatesInPlace {

    public static int removeDuplicates(int[] nums){

        if(nums.length < 1){
            return -1;
        }

        //arr -> 1 1 2 2 2 3 3 4 4;
        int i = 0;
        int j = 1;
        while(j < nums.length){

            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];

            }
            j++;

        }

        return i+1;
    }


    public static void main(String[] args) {

        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }
}
