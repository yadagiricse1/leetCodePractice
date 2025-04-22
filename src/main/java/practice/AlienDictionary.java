package practice;

import java.util.*;

public class AlienDictionary {

    private static String alienOrderBFSApproach(String[] words) {
        StringBuilder result = new StringBuilder();
        Map<Character,List<Character>> reverseOrdering = new HashMap<>();
        Map<Character,Integer> charCount = new HashMap<>();
        for(String word:words){
            for(char ch: word.toCharArray()){
                reverseOrdering.putIfAbsent(ch,new ArrayList<>());
                charCount.put(ch,0);
            }
        }
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2= words[i+1];
            if(word1.length()>word2.length() && word1.startsWith(word2))
                return "";

            int minStringLength= Math.min(word1.length(),word2.length());
            for(int j=0;j<minStringLength;j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    reverseOrdering.get(word1.charAt(j)).add(word2.charAt(j));
                    charCount.put(word2.charAt(j),charCount.get(word2.charAt(j))+1);
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for(char ch:charCount.keySet()){
            if(charCount.get(ch)==0){
                queue.add(ch);
            }
        }

        while(!queue.isEmpty()){
            char ch= queue.remove();
            result.append(ch);
            for(Character next:reverseOrdering.get(ch)){
                charCount.put(next, charCount.get(next) - 1);
                if (charCount.get(next).equals(0)) {
                    queue.add(next);
                }

            }

        }
        if (result.length() < charCount.size()) {
            return "";
        }
        return result.toString();
    }



    public static void main(String[] args) {

        String [] words ={"wrt","wrf","er","ett","rftt"};

        System.out.println(alienOrderBFSApproach(words));

    }

    private static String alienOrder(String[] words) {
        StringBuilder result = new StringBuilder();
        Map<Character,List<Character>> reverseOrdering = new HashMap<>();
        Map<Character,Boolean> seen = new HashMap<>();
        for(String word:words){
            for(char ch: word.toCharArray()){
                reverseOrdering.putIfAbsent(ch,new ArrayList<>());
            }
        }
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2= words[i+1];
            if(word1.length()>word2.length() && word1.startsWith(word2))
                return "";

            int minStringLength= Math.min(word1.length(),word2.length());
            for(int j=0;j<minStringLength;j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    reverseOrdering.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        for(char ch:reverseOrdering.keySet()){
              boolean ordered =  dfsAlienOrder(ch,reverseOrdering,result,seen);
              if(!ordered){
                  return "";
              }
        }


        return result.toString();

    }

    private static boolean dfsAlienOrder(char ch, Map<Character, List<Character>> reverseOrdering, StringBuilder result, Map<Character, Boolean> seen) {

    if(seen.containsKey(ch))
        return seen.get(ch);

    seen.put(ch, false);
    for(char nextCh:reverseOrdering.get(ch)){
        boolean ordered =  dfsAlienOrder(nextCh,reverseOrdering,result,seen);
        if(!ordered){
            return false;
        }
    }
    seen.put(ch, true);

    result.append(ch);
    return true;

    }

}
