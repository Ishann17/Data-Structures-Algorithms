package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {

    public static String minWindow(String s, String t) {

        // result window, empty by default if no valid window found
        String window = "";

        // required tracks how many characters from t are still unsatisfied in current window
        // starts at t.length() because all characters need to be covered
        int required = t.length();

        // edge case: s can never contain all of t if s is shorter
        if(s.length() < t.length()) {
            return window;
        }

        // tMap stores the frequency of each character needed from t
        // windowMap stores the frequency of each character in the current window
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // populate tMap with character requirements from t
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int low = 0, high = 0, minLen = Integer.MAX_VALUE;

        for(high = 0; high < s.length(); high++){

            // expand window: add character at high into windowMap
            windowMap.put(s.charAt(high), windowMap.getOrDefault(s.charAt(high), 0) + 1);

            // if this character is needed by t AND its window frequency just met the requirement
            // it means one more character from t is now satisfied — decrease required
            // using <= handles duplicates: for t="aaa", required decrements as 'a' goes 1->2->3
            if(tMap.containsKey(s.charAt(high)) && windowMap.get(s.charAt(high)) <= tMap.get(s.charAt(high))){
                required--;
            }

            // required == 0 means all characters of t are satisfied in current window
            while(required == 0){

                // update result only when current window is smaller than best found so far
                // use high+1 not low+minLen — minLen may belong to a previous smaller window
                int len = high - low + 1;
                if(len < minLen){
                    minLen = len;
                    window = s.substring(low, high + 1);
                }

                // shrink window from left: decrease frequency of character at low
                Integer count = windowMap.get(s.charAt(low));
                windowMap.put(s.charAt(low), count - 1);
                if(count - 1 == 0){
                    windowMap.remove(s.charAt(low));
                }

                // if the character we just removed was needed by t AND its frequency
                // dropped below requirement, one character is now unsatisfied — increase required
                if(tMap.containsKey(s.charAt(low)) && windowMap.getOrDefault(s.charAt(low), 0) < tMap.get(s.charAt(low))){
                    required++;
                }

                // move low forward to continue shrinking
                low++;
            }
        }

        return window;
    }

    private static boolean matches(int[]a, int[]b){
        for(int ind=0;ind<b.length;ind++){
            if(a[ind]<b[ind]) return false;
        }
        return true;
    }
    public static String minWindowSecondApproach(String s, String t) {

        int [] freqs=new int[128];
        int [] freqt=new int[128];

        int left=0;
        int m=s.length();
        int n=t.length();
        int temp=0;
        int minlen=Integer.MAX_VALUE;
        String ss="";

        if(n>m)return ss;

        for(char c:t.toCharArray()){
            freqt[c]++;
        }

        for(int right=0;right<m;right++){
            freqs[s.charAt(right)]++;
            while(matches(freqs,freqt)){
                int window=right-left+1;
                if(window<minlen){
                    minlen=window;
                    temp=left;

                }
                freqs[s.charAt(left)]--;
                left++;

            }
        }
        if( minlen==Integer.MAX_VALUE)return ss;
        return ss=s.substring(temp,temp+minlen);
    }

    public static void main(String[] args) {
        String s = "ba", t = "aa";
        System.out.println(minWindow(s,t));
    }
}
