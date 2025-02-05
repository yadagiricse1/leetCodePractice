package practice.contest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class FindValidPairofAdjacentDigitsinString {
    public static String findValidPair(String s) {
      char[] charArr = s.toCharArray();
        StringBuilder result= new StringBuilder();
        Map<Integer,Integer> numCount=new ConcurrentHashMap<Integer, Integer>();
        for( char ch:charArr){
            int num=ch-'0';
            int count = numCount.getOrDefault(num, 0) + 1;
            numCount.put(num,count);
        }
        List<Integer> finalNums= new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:numCount.entrySet()){
            if(e.getKey()==e.getValue()){
                finalNums.add(e.getKey());
            }
        }
        if(finalNums.size()==2){
            for(int i:finalNums){
                result.append(i);
            }
            int index1 = s.indexOf(result.toString());
            int index2 = s.indexOf(result.reverse().toString());
            if(index1==-1)
                return result.reverse().toString();
            else if(index2==-1)
                return result.toString();
            else if(index1<index2){
                return result.toString();
            } else  return result.reverse().toString();

        } else if(finalNums.size()>2){

            for(int i=0;i<finalNums.size();i++){
                String temp="";
                for(int j=i+1;j<finalNums.size()-1;j++){
                    temp=finalNums.get(i)+""+finalNums.get(j);
                }
                int index1 = s.indexOf(result.toString());
                int index2 = s.indexOf(result.reverse().toString());
                if(index1==-1 && index2==-1)
                   continue;
                else if(index2==-1)
                    return result.toString();
                else if(index1<index2){
                    return result.toString();
                } else  return result.reverse().toString();

            }

        }else return "";

return result.toString();
    }

    public static void main(String[] args) {
        String s="425555251";
        //System.out.println(s.indexOf("24"));

        System.out.println(findValidPair(s));

    }
}
