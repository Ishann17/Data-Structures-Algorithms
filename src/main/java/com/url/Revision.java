package com.url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Revision {

    static List<List<Integer>> threeSum(int[] a){

        Arrays.sort(a);
        int target = 0;

        List<List<Integer>> triplets = new ArrayList<>();

        for(int i=0; i<a.length-2; i++){

            //handle Duplicates
            if(i > 0 && a[i] == a[i-1]){
                continue;
            }

            int left = i+1;
            int right = a.length-1;

            while(left<right){
                int sum = a[i] + a[left] + a[right];
                if(sum == target){
                   triplets.add( List.of(a[i], a[left], a[right]));

                   left++;
                   right--;

                   while(left<right && a[left] == a[left-1]){
                       left++;
                   }
                    while(left<right && a[right] == a[right+1]){
                        right--;
                    }

                }else if (sum > target){
                    right--;
                }else {
                    left++;
                }
            }

        }
       return triplets;
    }




    public static void main(String[] args) {
       int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }
}
