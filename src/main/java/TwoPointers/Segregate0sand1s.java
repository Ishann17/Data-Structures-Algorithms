package TwoPointers;

import java.util.Arrays;

public class Segregate0sand1s {

    static void segregate0and1(int[] arr){

        int i=0;
        int j= arr.length-1;

        while(i<j){

            if(arr[i] == 0){
                i++;
            }
            else if(arr[j] == 1){
                j--;
            }else{
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,1};
        segregate0and1(arr);
    }
}
