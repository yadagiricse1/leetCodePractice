package practice.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximizeActiveSectionwithTradeI {
//https://leetcode.com/contest/biweekly-contest-153/problems/maximize-active-section-with-trade-i/description/
    public static int maxActiveSectionsAfterTrade(String s) {
      /* int count =0;

        if(s.length()<=2){
            for(char ch:s.toCharArray()){
                if(ch=='1')
                    count++;
            }
            return count;
        }

       int beginIndexOfZero = s.indexOf('0');
       int endIndexOfZero = s.lastIndexOf('0');
       List<Integer> oneIndexes = new ArrayList<>();
       boolean oneInBetweenZero = false;
       for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1' ){
                oneIndexes.add(i);
                if(i>beginIndexOfZero && i<endIndexOfZero){
                    oneInBetweenZero = true;
                }
            }
       }
       if(oneInBetweenZero){
           s='1'+s+'1';
           for(int i=0;i<oneIndexes.size();i++){
               oneIndexes.set(i,oneIndexes.get(i)+1) ;
           }
           int maxZerosWithOneIndex=-1;
           int maxCount = -1;
           for(int j:oneIndexes){
               int k=j-1;
               int counter=0;
               while(k>=0){
                   if(s.charAt(k)=='0'){
                       counter++;
                   } else{
                       break;
                   }
                   k--;
               }
               k=j+1;

               while(k<s.length()){
                   if(s.charAt(k)=='0'){
                       counter++;
                   } else{
                       break;
                   }
                   k++;
               }
               if(maxCount<counter){
                   maxCount=counter;
                   maxZerosWithOneIndex=j;
               }
           }
           char [] charArray = s.toCharArray();
           if(maxZerosWithOneIndex>-1)
               charArray[maxZerosWithOneIndex]='0';

           int k=maxZerosWithOneIndex-1;
           int result=0;
           while(k>0){
               if(charArray[k]=='0'){
                   charArray[k]='1';
               } else{
                   break;
               }
               k--;
           }
           k=maxZerosWithOneIndex+1;

           while(k<s.length()-1){
               if(charArray[k]=='0'){
                   charArray[k]='1';
               } else{
                   break;
               }
               k++;
           }

           k=maxZerosWithOneIndex-1;
           while(k>0){
               if(charArray[k]=='1'){
                   result++;
               } else{
                   break;
               }
               k--;
           }
           result++;
           k=maxZerosWithOneIndex+1;

           while(k<s.length()-1){
               if(charArray[k]=='1'){
                   result++;
               } else{
                   break;
               }
               k++;
           }

           return result;
       } else {
           if(!s.contains("0"))
               return s.length();

           if(s.contains("1")){
               int firstOccuranceOfZero = s.indexOf('0');
               int lastOccuranceOfZero = s.lastIndexOf('0');
               if(firstOccuranceOfZero==lastOccuranceOfZero){
                   return s.length()-1;
               } else {
               String []substrings =    s.split("0");
               int maxOnes=0;
               for(String substring:substrings){
                       maxOnes+=substring.length();
               }

               return maxOnes;

               }

           } else
               return 0;

       }
*/
        return 0;
    }
    public static void main(String[] args) {
//101
        String s="1001";
        System.out.println(maxActiveSectionsAfterTrade(s));

    }
}
