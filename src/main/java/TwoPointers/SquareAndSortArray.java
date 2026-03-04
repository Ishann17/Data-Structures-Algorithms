package TwoPointers;

import java.util.Arrays;

public class SquareAndSortArray {

    static int[] squareOfSortedArray(int [] nums){

        int[] result = new int[nums.length];
        int i=0;
        int j= nums.length-1;
        int index = result.length-1;

        while(i<=j){

            int leftSquare = nums[i] * nums[i];
            int rightSquare = nums[j] * nums[j];
            if(leftSquare < rightSquare){
                result[index] = rightSquare;
                index--;
                j--;
            }else{
                result[index] = leftSquare;
                index--;
                i++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int [] a = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(squareOfSortedArray(a)));

    }
}
