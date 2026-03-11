package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithKUniques {

    static int longestKSubstring(String s, int k){

        int low=0;
        int high=0;

        int result = -1;

        //Frequency map to keep track of characters
        Map<Character, Integer> map = new HashMap<>();

        for(high=0; high<s.length(); high++){
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0)+1);

            //Handle three conditions
            //1. map.size == k
            if(map.size() == k){
                int lengthOfSubString = high-low+1;
                result = Math.max(result, lengthOfSubString);
            }

            //2. if map.size < k
            /*if(map.size() < k){
                //we should not shrink the window because shrinking will decrease size, we need to increase the size
                continue;
            }*/

            //Size if more than k here we need to decrease the size.
            if(map.size() > k){

                //check current frequency
                Integer freq = map.get(s.charAt(low));

                //decrement the freq by 1
                map.put(s.charAt(low), freq-1);

                //check after decrementing if freq is zero, then remove from map
                if(freq-1 == 0){
                    map.remove(s.charAt(low));
                }

                //shrink window from left
                low++;

            }
        }


        return result;
    }

    public static void main(String[] args) {

        String s = "aabaaab";
        int k = 2;

        System.out.println(longestKSubstring(s,k));
    }
}
