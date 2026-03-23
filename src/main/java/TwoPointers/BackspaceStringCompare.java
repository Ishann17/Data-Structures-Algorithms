package TwoPointers;

import javax.xml.stream.events.Characters;
import java.util.Stack;

public class BackspaceStringCompare {

    public static boolean backspaceCompareBruteForce(String s, String t) {

        Stack<Character> stackOne = new Stack<>();
        Stack<Character> stackTwo = new Stack<>();

        for(char ch : s.toCharArray()){
           if(ch != '#'){
               stackOne.push(ch);
           }else{
               if(!stackOne.isEmpty()){
                   stackOne.pop();
               }
           }
        }


        for(char ch : t.toCharArray()){
            if(ch != '#'){
                stackTwo.push(ch);
            }else{
                if(!stackTwo.isEmpty()){
                    stackTwo.pop();
                }
            }
        }


        return stackOne.equals(stackTwo);
    }

    public static boolean backspaceCompareOptimized(String s, String t) {

        int i=s.length()-1;
        int j=t.length()-1;

        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {
            // Find the next valid character in s
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            // Find the next valid character in t
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            // Compare the two valid characters
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                // One string has characters left but the other doesn't
                return false;
            }
            i--;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ab##c";
        String c = "c";

        System.out.println(backspaceCompareOptimized(s,c));

    }
}
