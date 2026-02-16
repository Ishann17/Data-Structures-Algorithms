package TwoPointers;

import java.util.Arrays;
//Link : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumUsingPointers {

    public static int[] findPairsSumEqualToTarget(int[] arr, int target){
        int[] result = new int[2];
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum==target){
                result[0] = left+1;
                result[1] = right+1;
                return result;
            } else if (sum > target) {
                right--;
            }else{
                left++;
            }
        }
        return result;
    }
//Link : https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1
    //returns number of pairs whose sum is equal to target
    static int countPairs(int[] arr, int target){

        int count = 0;
        int left = 0; int right = arr.length-1;

        while(left<right){
            int check = arr[left] + arr[right];

            if(check == target){
                int leftCount = 0;
                int rightCount = 0;
                int leftValue = arr[left];
                int rightValue = arr[right];
                // SCENARIO 1: All elements between left and right are the same!
                // Example: [2, 2, 2] target: 4. left is 0, right is 2.
                if(leftValue == rightValue){
                    int n = right - left + 1;
                    count += (n * (n-1))/2;
                    break;
                }
                // SCENARIO 2: Different numbers (e.g., 1 and 5)
                while(left < right && arr[left] == leftValue){
                    leftCount++;
                    left++;
                }
                while(right>=left && arr[right] == rightValue){
                    rightCount++;
                    right--;
                }
                count += leftCount * rightCount;
            }
            else if (check > target) {
                right--;
            }else{
                left++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        //In this problem array will always be sorted in ascending order
        int[] arr = {-17 ,-15 ,-13 ,-9 ,-4 ,0 ,0 ,0 ,1 ,5 ,9 ,12 ,18 ,18};
        int target = 0;
        System.out.println(countPairs(arr,target));
    }
}
