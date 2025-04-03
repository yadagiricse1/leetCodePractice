package practice;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> groupedAnagrams = new HashMap<>();
        for(String str: strs){
            char [] charArray =str.toCharArray();
            Arrays.sort(charArray);
           String sortedString = String.valueOf(charArray);
            if(!groupedAnagrams.containsKey(sortedString)){
                groupedAnagrams.put(sortedString,new ArrayList<>());
            }
            groupedAnagrams.get(sortedString).add(str);
        }
        List<List<String>> results = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry:groupedAnagrams.entrySet()){
            results.add(entry.getValue());
        }
        return results;
    }

    public static void main(String[] args) {
        String [] strs ={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> results = groupAnagrams(strs);
        for(List<String> result:results)
            System.out.println(result);


    }
}
