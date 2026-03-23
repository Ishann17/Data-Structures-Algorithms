package com.url;

import java.util.Arrays;

public class Revision {

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l=0, r=s.length()-1;

        while(l < r){

            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }

            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;

        }

        return true;
    }


    public static void main(String[] args) {
        String s = " ";
        System.out.println(isPalindrome(s));
    }
}
