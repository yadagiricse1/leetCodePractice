package practice.contest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MaxDiffBetweenEvenAndOddFrequency1 {
    public static int maxDifference(String s) {
        Map<Character,Integer> charCount=new HashMap<>();
        for(char ch:s.toCharArray()){
            int count = charCount.getOrDefault(ch, 0) + 1;
            charCount.put(ch,count);
        }
       int evenMax=Integer.MIN_VALUE;
        int evenMin=Integer.MAX_VALUE;
        int oddMax=Integer.MIN_VALUE;
        int oddMin=Integer.MAX_VALUE;
       List<Integer> even= charCount.values().stream().filter(i->i%2==0).collect(Collectors.toList());
        List<Integer> odd =charCount.values().stream().filter(i->i%2!=0).collect(Collectors.toList());
                for(Integer i:even){


                        if(evenMax<i){
                            evenMax=i;
                        }
                        if(evenMin>i){
                            evenMin=i;
                        }

                }
        for(Integer i:odd){
            if(oddMax<i){
                oddMax=i;
            }
            if(oddMin>i){
                oddMin=i;
            }

        }

            return  oddMax-evenMin;

    }

    public static void main(String[] args) {
        String s="aaaaabbc";
        System.out.println(maxDifference(s));

    }
}
