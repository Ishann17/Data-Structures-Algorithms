package TwoPointers;

import java.util.Arrays;

public class TripletsWithSmallerSum {

    //https://www.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1
    static long countTriplets(int n, int target, long arr[]) {

        Arrays.sort(arr);
        long triplets = 0;
        for(int i=0; i< arr.length; i++){
            int left = i+1;
            int right = arr.length-1;
            while(left < right){
                long currentSum = arr[i] + arr[left] + arr[right];
                if(currentSum >= target){
                    right--;
                } else {
                    triplets += right - left;
                    left++;
                }
            }
        }

        return triplets;

    }

    public static void main(String[] args) {

        long[] a = {30,8,23,6,10,9,31,7,19,20,1,33,21,27,28,3,25,26};
        int n = a.length;
        int target = 86;

        System.out.println(countTriplets(n,target, a));
    }
}
