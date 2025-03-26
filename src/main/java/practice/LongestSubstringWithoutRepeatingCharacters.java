package practice;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int strLength=s.length();
        if(strLength==0||strLength==1)
            return strLength;

     int result=0;
     Map<Character,Integer> charIndex = new HashMap<>();
     int beginIndex=0;
        charIndex.put(s.charAt(0),0);
        for(int i=1;i<strLength;i++){
            char ch=s.charAt(i);
            if(charIndex.containsKey(ch)){
                if(beginIndex<charIndex.get(ch)+1){
                    beginIndex=charIndex.get(ch)+1;
                }
            }
            result= Math.max(result,i-beginIndex+1);

            charIndex.put(ch,i);


        }
        return result;
    }
    public static void main(String[] args) {

        String s="dvdf";
        System.out.println(lengthOfLongestSubstring(s));


    }
}
