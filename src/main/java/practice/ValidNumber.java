package practice;

import java.util.*;

public class ValidNumber {

    public static boolean  isNumber(String s) {
        boolean seenDigit = false;
        boolean seenExponent = false;
        boolean seenDot = false;

        for(int i=0;i<s.length();i++){
            char currChar= s.charAt(i);
            if(Character.isDigit(currChar)){
                seenDigit=true;
            } else if(currChar=='+'||currChar=='-'){
                if(i>0&&(s.charAt(i - 1) != 'e' ||s.charAt(i - 1) != 'E')){
                    return false;
                }
            } else if(currChar == 'e' || currChar == 'E'){
                if(seenExponent||!seenDigit){
                    return false;
                }
                seenExponent=true;
                seenDigit = false;// we are making this false to make sure that we get digit later or not
            } else if(currChar=='.'){
                if(seenDot||seenExponent){
                    return false;
                }
                seenDot=true;
            }  else {
                return false;
            }
        }
        return seenDigit;
    }

    //This is covering most of the testcase but not a good solution 1486 / 1496 testcases passed
    public  static boolean isNumber1(String s) {

        String s1 = s.replaceAll("\\.","").replaceAll("-","").replaceAll("e","").replaceAll("\\+","");
         if(s1.isEmpty())
             return false;
         String s2=null;
         if(s.charAt(0)=='-'||s.charAt(0)=='+')
             s2=s.substring(1);
         else
             s2=s;
         if(!s2.isEmpty()){
             if(s2.length()>1&&!Character.isDigit(s2.charAt(0))&&!Character.isDigit(s2.charAt(1)))
                 return false;

         }

        Map<Character,List<Integer>> charIndex = new HashMap<>();
        char [] chArray = s.toCharArray();
        List<Character> includedChars = List.of('.','-','+','E','e');
        int length = s.length();
        if(length==1)
            return Character.isDigit(chArray[0]);

        if(Character.isAlphabetic(chArray[0])||Character.isAlphabetic(chArray[length-1])||chArray[length-1]=='-'||chArray[length-1]=='+')
            return false;
      for(int i=0;i<chArray.length;i++){
          char ch=chArray[i];
          if(!Character.isDigit(ch)){
              ch= Character.toLowerCase(ch);
              if(!includedChars.contains(ch))
                  return false;
              if(charIndex.containsKey(ch)) {
                  List<Integer> indies= charIndex.get(ch);
                  if(indies.get(indies.size()-1)==(i-1))
                      return false;
                  if(ch=='+') {
                      List<Integer> indiesMinus= charIndex.get('-');
                      if(null!=indiesMinus&&!indiesMinus.isEmpty()&&indiesMinus.get(indies.size()-1)==(i-1))
                          return false;
                  } else  if(ch=='-') {
                      List<Integer> indiesPlus= charIndex.get('+');
                      if(null!=indiesPlus&&!indiesPlus.isEmpty()&&indiesPlus.get(indies.size()-1)==(i-1))
                          return false;
                  }
              }
          }
          charIndex.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
      }

      if(charIndex.containsKey('.')){
          if(charIndex.get('.').size()>1)
              return false;
      }

      if(charIndex.containsKey('e'))
          if(charIndex.get('e').size()>1)
              return false;

        List<Integer> plusMinusIndices = new ArrayList<>();
        plusMinusIndices.addAll(charIndex.getOrDefault('-',new ArrayList<>()));
        plusMinusIndices.addAll(charIndex.getOrDefault('+',new ArrayList<>()));

     for(int index:plusMinusIndices){
         if(plusMinusIndices.contains(index+1))
             return false;
     }
     if(plusMinusIndices.size()>2)
         return false;
     if(charIndex.containsKey('e')&&charIndex.containsKey('.')){
      int indexDot=   charIndex.get('.').get(0);
         int indexE=   charIndex.get('e').get(0);
         if(indexDot>indexE)
             return false;
        Set<Character>  keys=charIndex.keySet();
         keys.remove('e');
         keys.remove('.');





     }
        if(charIndex.containsKey('e')&&(charIndex.containsKey('+')||charIndex.containsKey('-'))){
            int indexE =   charIndex.get('e').get(0);
            if(plusMinusIndices.contains(indexE-1))
                return false;

        }

        if(!charIndex.containsKey('e')){
            for(int ind:plusMinusIndices){
                if(ind!=0)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s="3.5e+3.5e+3.5";


        System.out.println(isNumber(s));




    }
}
