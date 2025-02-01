package practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));

    }


    public static int romanToInt(String s) {
        Map<Character,Integer> charIntVal=new HashMap<>();
        charIntVal.put('I',1);
        charIntVal.put('V',5);
        charIntVal.put('X',10);
        charIntVal.put('L',50);
        charIntVal.put('C',100);
        charIntVal.put('D',500);
        charIntVal.put('M',1000);
        int value=0;
        char[] charArray=s.toCharArray();
       for(int i=0;i<charArray.length;i++){
           char ch=charArray[i];
           int num=charIntVal.get(ch);
           if(i+1<charArray.length&& charIntVal.get(ch)<charIntVal.get(charArray[i+1])){
                   num=-1*num;
           }
           value+=num;
       }

        return value;
    }


}
