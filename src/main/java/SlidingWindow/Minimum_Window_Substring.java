package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Minimum_Window_Substring {

    public static String minWindow(String s, String t) {

        // edge case: s can never contain all of t if s is shorter
        if(s.length() < t.length()) return "";

        // tMap stores the frequency of each unique character required from t
        // windowMap stores the frequency of each character in the current window
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // populate tMap with character requirements from t
        for(char ch : t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        // needed = number of unique characters in t that must be fully satisfied
        // have = number of unique characters currently fully satisfied in the window
        // when have == needed, the window is valid
        int needed = tMap.size();
        int have = 0;

        // result stores [start, end] indices of the best window found
        int[] result = {-1, -1};
        int minLength = Integer.MAX_VALUE;

        int low = 0;
        for(int high = 0; high < s.length(); high++){

            // expand window: add character at high into windowMap
            char ch = s.charAt(high);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

            // if this character is needed by t AND its frequency exactly matches
            // the requirement, this unique character is now fully satisfied
            if(tMap.containsKey(ch) && windowMap.get(ch).equals(tMap.get(ch))){
                have++;
            }

            // have == needed means all unique characters of t are fully satisfied
            while(have == needed){

                // update result if current window is smaller than best found so far
                int len = high - low + 1;
                if(len < minLength){
                    minLength = len;
                    result[0] = low;
                    result[1] = high;
                }

                // shrink window from left: decrease frequency of character at low
                char leftChar = s.charAt(low);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                // if removed character was needed by t AND its frequency dropped
                // below requirement, it is no longer satisfied — decrease have
                if(tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)){
                    have--;
                }

                // move low forward to continue shrinking
                low++;
            }
        }

        // return best window found, or empty string if no valid window exists
        return minLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
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
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
}
