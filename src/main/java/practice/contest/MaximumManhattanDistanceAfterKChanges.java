package practice.contest;

import java.util.HashMap;
import java.util.Map;

public class MaximumManhattanDistanceAfterKChanges {

    //not a valid solution. We should Order as it is.
    public static int maxDistance(String s, int k) {
        Map<Character,Integer> charMap= new HashMap<>();
        charMap.put('N',0);
        charMap.put('S',0);
        charMap.put('E',0);
        charMap.put('W',0);
        Map<Character,Character> directionOpponent=new HashMap<>();
        directionOpponent.put('N','S');
        directionOpponent.put('S','N');
        directionOpponent.put('E','W');
        directionOpponent.put('W','E');
        char[] charArr=s.toCharArray();
        char chMaxDir=charArr[0];
        int maxCount=0;
        for(char ch:s.toCharArray()){
            int count = charMap.getOrDefault(ch, 0) + 1;
            charMap.put(ch,count);
            if(maxCount<=count){
                maxCount=count;
                chMaxDir=ch;
            }
        }
        int maxDistance=0;

        while(k>0&&charMap.get(directionOpponent.get(chMaxDir))>0){
                charMap.put(chMaxDir,charMap.get(chMaxDir)+1);
                charMap.put(directionOpponent.get(chMaxDir),charMap.get(directionOpponent.get(chMaxDir))-1);
        k--;
        }
        maxDistance+=charMap.get(chMaxDir);

        if(chMaxDir=='N'||chMaxDir=='S'){
            if(charMap.get('E')>charMap.get('W')){
                chMaxDir='E';
            } else{
                chMaxDir='W';
            }
        } else {
            if(charMap.get('N')>charMap.get('S')){
                chMaxDir='N';
            } else{
                chMaxDir='S';
            }
        }
        while(k>0&&charMap.get(directionOpponent.get(chMaxDir))>0){
            charMap.put(chMaxDir,charMap.get(chMaxDir)+1);
            charMap.put(directionOpponent.get(chMaxDir),charMap.get(directionOpponent.get(chMaxDir))-1);
            k--;
        }

        maxDistance+=charMap.get(chMaxDir);


        return maxDistance;
    }
    public static void main(String[] args) {
        //System.out.println(maxDistance("NWSE",1));
        System.out.println(maxDistance("EWWE",0));

    }
}
