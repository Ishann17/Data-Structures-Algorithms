package TwoPointers;

import java.util.Arrays;

public class ValidPalindrome {

    public static boolean checkPalindrome(String s){

        int left = 0;
        int right = s.length()-1;

        while(left <= right){

            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }

            char l = Character.toLowerCase(s.charAt(left));
            char r = Character.toLowerCase(s.charAt(right));
            if(l != r){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(checkPalindrome(str));
    }
}
