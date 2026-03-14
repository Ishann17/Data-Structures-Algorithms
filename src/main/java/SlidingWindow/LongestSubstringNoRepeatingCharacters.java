package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringNoRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int maxLen = 0;
        int low=0, high=0;
        for(high=0; high<s.length(); high++){


            //Add every character at high into the map, update their frequency
            freqMap.put(s.charAt(high), freqMap.getOrDefault(s.charAt(high), 0)+1);

            //if any character's frequency is more than 1 it is repeating
            while(freqMap.get(s.charAt(high)) > 1){
                // we will now shrink the window
                Integer currentCount = freqMap.get(s.charAt(low));
                freqMap.put(s.charAt(low), currentCount-1);

                if(currentCount-1 == 0){
                    freqMap.remove(s.charAt(low));
                }
                //shrink
                low++;
            }
            maxLen = Math.max(high-low+1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
