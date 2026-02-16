package HaveISeenThisBefore;

import java.util.*;

public class TwoSum {


    public static List<Integer> twoSumPairs(int[] a, int target){
        //Have I seen a Number that Complete the sum.

        //This problem requires number & indices so using Map.
        Map<Integer,Integer> map = new LinkedHashMap<>(); //Using it to preserve insertion order.

        for (int i = 0; i < a.length; i++) {
            //We check BEFORE adding to map
            int complement = target - a[i];
            if(map.containsKey(complement)){
                return List.of(map.get(complement),i);
            }
            map.put(a[i], i); //key = number, value = index
        }

        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15,3,7,89,67,61,94,3,141,178,69,37,55};
        int target = 6;

        System.out.println(twoSumPairs(arr, target));
    }

}
