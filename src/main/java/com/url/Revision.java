package com.url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision {

    static int minLengthSum(int[] a, int k){

        int low=0, minLen = Integer.MAX_VALUE, sum=0;

        for(int high=0; high<a.length; high++){

             sum += a[high];

             while(sum >= k){
                 int len = high-low+1;
                 minLen = Math.min(minLen, len);
                 sum -= a[low];
                 low++;
             }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }




    public static void main(String[] args) {
       int[] arr = {};
       int target = 7;
        System.out.println(minLengthSum(arr, target));
    }
}
