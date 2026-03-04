package com.url;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Revision {

    static int[] mergeTwoSortedArrays(int[] nums1, int m, int[] nums2, int n){

        int i = m-1; // all possible elements to be merged in array 1
        int j= n-1; //  all possible elements to be merged in array 2
        int k = m+n-1; // total length of array 1 i.e. m+n-1

        //assuming both have some no. of elements
        while(i>=0 && j>=0){

            if(nums1[i] >= nums2[j]){
                nums1[k] = nums1[i];
                k--;
                i--;
            }else{
                nums1[k] = nums2[j];
                k--;
                j--;
            }

        }
        while(j >= 0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }

        return nums1;
    }




    public static void main(String[] args) {
        List<Integer> nums = List.of(1,0,7,8,0,9,11,0,0,2,3,27,19,45,0,99,0,0);
        List<Integer> list = Stream.concat(nums.stream().filter(e -> e != 0), nums.stream().filter(e -> e == 0)).toList();
        System.out.println(list);
    }
}
