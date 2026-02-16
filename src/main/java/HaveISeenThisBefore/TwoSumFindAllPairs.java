package HaveISeenThisBefore;

import java.util.*;

/*
Link to Problem : https://www.geeksforgeeks.org/problems/all-distinct-pairs-with-given-sum/1
Lexicographically = "Dictionary order" or "Alphabetical order"
But for numbers, it means: sort by the first number, then by the second number if the first is the same*/
public class TwoSumFindAllPairs {

    //We need One List<Int> to hold a single pair, We need outter List to hold All the distinct pairs
    public static List<List<Integer>> findAllPairs(int[] arr, int target){
        Arrays.sort(arr);
        //This list will hold All distinct Pairs
        List<List<Integer>> distinctPairs = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for(int j=i+1; j<arr.length; j++){
                //Add and check
                int check = arr[i] + arr[j];
                if(check == target){
                    int first = Math.min(arr[i], arr[j]);
                    int second = Math.max(arr[i], arr[j]);
                    //prepare a pair
                    List<Integer> currentPairs = new ArrayList<>
                            (Arrays.asList(first, second));
                    //if pair already added then don't add.
                    if(!distinctPairs.contains(currentPairs)){
                        distinctPairs.add(currentPairs);
                    }
                }
            }

        }

        return distinctPairs;
    }

    public static List<List<Integer>> optimizedFindAllPairs(int[] arr, int target){

        //This list will hold All distinct Pairs
        List<List<Integer>> distinctPairs = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if(complement == arr[i]){
                if(map.getOrDefault(complement, 0)==1);
                    distinctPairs.add(Arrays.asList(arr[i], arr[i]));
            }

            // if complement is not equal to arr[i], then there should
            // be at least one occurrence of complement and no occurrence
            // of current element in the hash map
            else if (map.getOrDefault(complement, 0) > 0
                    && map.getOrDefault(arr[i], 0) == 0) {
                int first = Math.min(arr[i], complement);
                int second = Math.max(arr[i], complement);
                distinctPairs.add(Arrays.asList(first, second));
            }

            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        }

        return distinctPairs;
    }


    public static void main(String[] args) {
        int [] arr = {1, 5, 7, -1, 5};
        int target = 6;
        System.out.println(findAllPairs(arr,6));
    }
}
