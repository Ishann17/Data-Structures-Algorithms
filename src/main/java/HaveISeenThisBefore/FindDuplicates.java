package HaveISeenThisBefore;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

    public static int findDuplicate(int[] arr){
        // Pattern: "Have I seen this before?"
        // Tool: HashSet for O(1) existence check
        //We need to scan the array and check if we have seen a number before.
        //To register if we have seen a number before
        Set<Integer> duplicate = new HashSet<>();

        //Scanning requires a loop
        for (int i : arr) {
            //set.add() return true for unique, false for duplicate
            if (!duplicate.add(i))
                return i; //duplicate returned
        }

        return -1; //no duplicate found, return -1
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 2, 3, 5, 1, 2, 4};
        System.out.println(findDuplicate(arr));
    }
}
