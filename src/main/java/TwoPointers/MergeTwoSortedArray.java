package TwoPointers;

import java.util.Arrays;
//Link - https://leetcode.com/problems/merge-sorted-array/
public class MergeTwoSortedArray {

    //Array a & b are in ascending sorted order
    static int[] mergeTwoArraysInSorted(int[] a, int[] b){

        int n = a.length;
        int m = b.length;

        int[] result = new int[n+m];
        int i = 0;
        int j = 0;
        int index = 0;

        while(i<n  && j<m){

            if(a[i] < b[j]){
                result[index] = a[i];
                index++;
                i++;
            }
            else{
                result[index] = b[j];
                index++;
                j++;
            }

        }
        while(j<m){
            result[index] = b[j];
            index++;
            j++;
        }

        while(i<n){
            result[index] = a[i];
            index++;
            i++;
        }

        return result;
    }

    static void mergeTwoSortedArraysInPlace(int[] a, int m, int[] b, int n){

        int i=m-1, j=n-1, k=m+n-1;

        while(j>=0){

            if(i>=0 && a[i] > b[j]){
                a[k] = a[i];
                k--;
                i--;
            }
            else{
                a[k] = b[j];
                k--;
                j--;
            }

        }
        System.out.println(Arrays.toString(a));
    }

    public static void main(String[] args) {
        int[] a = {0};
        int[] b = {1};
        int n = b.length;
        int m = a.length-n;
        System.out.println("Value of m :: " + m);

        mergeTwoSortedArraysInPlace(a,m,b,n);

        //System.out.println(Arrays.toString(mergeTwoArraysInSorted(a,b)));
    }
}
