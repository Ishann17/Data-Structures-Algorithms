package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement {

    public static int characterReplacement(String s, int k) {

        int maxLen = Integer.MIN_VALUE, maxFreq = 0, low = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int high=0; high<s.length(); high++){
            // Expand window: add new character at high and update its frequency
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0)+1);
            maxFreq = Math.max(maxFreq, map.get(s.charAt(high)));

            //calculate current window length
            int len = high-low+1;

            // Replacements needed = window length - most frequent character count
            // If this is <= k, window is valid (we can make all chars same with k replacements)
            int diff = len - maxFreq;

            if(diff <= k){
                //valid window
                maxLen = Math.max(maxLen, len);
            }

            //when diff > k Window invalid: too many replacements needed, shrink from left until valid
            while(diff > k){
                Integer count = map.get(s.charAt(low));
                map.put(s.charAt(low), count-1);

                if(count-1 == 0){
                    map.remove(s.charAt(low));
                }
                low++;
                // maxFreq is not recalculated during shrink — a smaller maxFreq won't give a longer window
                // so we keep the old maxFreq and just recalculate diff with new window length
                int currLen = high-low+1;
                diff = currLen - maxFreq;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABBC";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}
