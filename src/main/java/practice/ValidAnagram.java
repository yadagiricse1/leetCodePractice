package practice;

import java.util.Arrays;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;

        int [] charCount= new int[26];
        for(int i=0;i<s.length();i++){
            charCount[s.charAt(i)-97]++;
        }
        for(int i=0;i<t.length();i++){
            int c=t.charAt(i)-97;
            charCount[c]--;
            if(charCount[c]<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagrama";
        String t = "nagarama";
        System.out.println(isAnagram(s,t));

    }
}
