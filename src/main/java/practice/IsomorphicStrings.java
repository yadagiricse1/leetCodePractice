package practice;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {

        //Same can be done with 2 26 character arrays
        Map<Character, Character> charMap1= new HashMap<>();
        Map<Character, Character> charMap2= new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(charMap1.containsKey(ch1)){
                if(ch2!=charMap1.get(ch1))
                    return false;
            } else if(charMap2.containsKey(ch2)){
                return false;
            } else {
                charMap1.put(ch1,ch2);
                charMap2.put(ch2,ch1);
            }
        }
        return true;
    }
    public static boolean isIsomorphic2(String s, String t) {
        Map<Character, Integer> indexMapping= new HashMap<>();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!indexMapping.containsKey(ch))
                indexMapping.put(s.charAt(i),i);
            sb1.append(indexMapping.get(s.charAt(i)));
            sb1.append(" ");
        }
        Map<Character, Integer> indexMapping2= new HashMap<>();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(!indexMapping2.containsKey(ch))
                indexMapping2.put(t.charAt(i),i);
            sb2.append(indexMapping2.get(t.charAt(i)));
            sb2.append(" ");
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static boolean isIsomorphic1(String s, String t) {
        Map<Character, Character> charMap1= new HashMap<>();
        Map<Character, Character> charMap2= new HashMap<>();
        for(int i=0;i<s.length();i++){
            charMap1.put(s.charAt(i),t.charAt(i));
            charMap2.put(t.charAt(i),s.charAt(i));

        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb1.append(charMap1.get(s.charAt(i)));
            sb2.append(charMap2.get(t.charAt(i)));
        }
        return sb1.toString().equals(t)&&sb2.toString().equals(s);

    }

    public static void main(String[] args) {
        String s="abcdefghijklmnopqrstuvwxyzva";
        String t="abcdefghijklmnopqrstuvwxyzck";
        System.out.println(isIsomorphic(s,t));


    }
}
