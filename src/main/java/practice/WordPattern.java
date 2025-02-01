package practice;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s){
        Map charStringIndexMap= new HashMap<>();
        String [] words=s.split(" ");
        if(words.length!=pattern.length())
            return false;
        for(int i=0;i<words.length;i++){
            String ch=""+pattern.charAt(i);
            String word=words[i].trim();
            if (!charStringIndexMap.containsKey(ch))
                charStringIndexMap.put(ch,i);
            if (!charStringIndexMap.containsKey(word))
                charStringIndexMap.put(word,i);
            if(!charStringIndexMap.get(ch).equals(charStringIndexMap.get(word)))
                return false;

        }

        return true;
    }
    public static boolean wordPattern2(String pattern, String s) {
        Map<Character, String> charToStringMapping= new HashMap<>();
        Map<String, Character> stringToCharMapping= new HashMap<>();
        String [] words=s.split(" ");
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            String word=words[i].trim();
            if(charToStringMapping.containsKey(ch)){
                if(!word.equals(charToStringMapping.get(ch)))
                    return false;
            } else if(stringToCharMapping.containsKey(word)){
                return false;
            } else{
                charToStringMapping.put(ch,word);
                stringToCharMapping.put(word,ch);
            }

        }

        return true;
    }
    public static boolean wordPattern1(String pattern, String s) {
        Map<Character, Integer> indexMapping= new HashMap<>();
        StringBuilder sb1 = new StringBuilder();
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            if(!indexMapping.containsKey(ch))
                indexMapping.put(pattern.charAt(i),i);
            sb1.append(indexMapping.get(pattern.charAt(i)));
            sb1.append(" ");
        }
        String [] words=s.split(" ");
        Map<String, Integer> indexMapping2= new HashMap<>();
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<words.length;i++){
           String word= words[i].trim();
            if(!indexMapping2.containsKey(word))
                indexMapping2.put(word,i);
            sb2.append(indexMapping2.get(word));
            sb2.append(" ");
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s="s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern(pattern,s));

    }
}
