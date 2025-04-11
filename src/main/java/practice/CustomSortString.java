package practice;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    public  static String customSortString(String order, String s){
        int [] map = new int [26];
        for (int i = 0; i < s.length(); i ++) {
            map[s.charAt(i) - 'a'] ++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<order.length();i++){
            for(int j=0;j<map[order.charAt(i) - 'a'];j++){
                sb.append(order.charAt(i));
            }
            map[order.charAt(i) - 'a']=0;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<map[i];j++){
                sb.append((char) ('a' + i));
            }

        }

      /*  int[] count = new int[26];

        for(char ch : s.toCharArray())
            count[ch-'a']++;

        StringBuilder sb = new StringBuilder();
        for(char ch : order.toCharArray()){
            while(count[ch-'a']-- > 0)
                sb.append(ch);
        }

        for(char ch : s.toCharArray()){
            while(count[ch-'a']-- > 0)
                sb.append(ch);
        }*/
        return sb.toString();
    }

    public  static String customSortString1(String order, String s) {
        Map<Character,Integer> charCount = new HashMap<>();

        for(char ch:s.toCharArray()){
            charCount.put(ch,charCount.getOrDefault(ch,0)+1);
        }
        StringBuilder sb = new StringBuilder();

        for(char ch:order.toCharArray()){
             if(charCount.containsKey(ch)){
               int count =  charCount.get(ch);
               while(count>0){
                   sb.append(ch);
                   count--;
               }
                 charCount.remove(ch);
             }
        }
        for(Map.Entry<Character,Integer> entry:charCount.entrySet()){
            int count =  entry.getValue();
            while(count>0){
                sb.append(entry.getKey());
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String order = "bcafg";
        String s = "abcd";
        System.out.println(customSortString(order,s));

    }
}
