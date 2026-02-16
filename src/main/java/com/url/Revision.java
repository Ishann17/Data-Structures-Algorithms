package com.url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision {

    static int closetSum(int[] a, int target){

        Arrays.sort(a);

        int n=a.length;
        int closestSum = a[0]+a[1]+a[2];

        for(int i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;

            while(left<right){
                int currentSum = a[i] + a[left] + a[right];

                if(Math.abs(currentSum - target) < Math.abs(closestSum - target)){
                    closestSum = currentSum;
                }
                if(currentSum == target){
                    return currentSum;
                }
                else if (currentSum < target) {
                    left++;
                }else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] a = {-1,2,1,-4};
        int target = 1;
        System.out.println(closetSum(a,target));
    }
}
