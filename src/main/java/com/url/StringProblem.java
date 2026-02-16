package com.url;

public class StringProblem {

    public static boolean checkString(String s) {

        for(int i=0; i<s.length()-1; i++){

            if(s.charAt(i) == 'b' && s.charAt(i+1) != 'b'){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(checkString(s));
    }
}


