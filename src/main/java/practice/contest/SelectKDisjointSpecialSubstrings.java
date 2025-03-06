package practice.contest;

import java.util.*;

public class SelectKDisjointSpecialSubstrings {
    public boolean maxSubstringLength(String s, int k) {
        Map<Character,List<Integer>> charIndex= new HashMap<>();
        char[] charArray= s.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(!charIndex.containsKey(charArray[i])){
                charIndex.put(charArray[i], new ArrayList<>());
            }
            charIndex.get(charArray[i]).add(i);
        }
        int oneCharDistinct=0;
        for(Map.Entry<Character,List<Integer>> entry:charIndex.entrySet()){
            if(entry.getValue().size()==1)
                oneCharDistinct++;
        }

        if(oneCharDistinct==k)
            return true;
        for(int i=2;i<charArray.length-1;i++){
            Set<String> nCharacterSet=new HashSet<>();

            for(int j=0;j<charArray.length-i;j++){
                int beginIndex=j;
                int endIndex=j+i;
               String temp= s.substring(j,j+i+1);
                for(int m = beginIndex;m<=endIndex;m++){
                    if(charIndex.get(charArray[m]).size()>1){
                        List<Integer> indexes=charIndex.get(charArray[m]);
                        for(int index:indexes){
                            if(index!=m){
                                if(index>endIndex){

                                }
                            }

                        }

                    }
                }



            }
        }



        return false;

    }

    public static void main(String[] args) {

    }
}
