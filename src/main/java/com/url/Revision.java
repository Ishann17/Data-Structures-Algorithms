package com.url;

import java.util.Arrays;

public class Revision {

    public static void sort012(int[] arr) {

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
      int [] a = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(a);


    }
}
