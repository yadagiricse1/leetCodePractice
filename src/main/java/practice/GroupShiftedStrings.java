package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

    public static char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }

    public static String hash(String s){
        char [] chArray = s.toCharArray();

        char letter =chArray[0];
        for(int i=0;i<s.length();i++){
            chArray[i]= shiftLetter(chArray[i],letter);
        }
        return String.valueOf(chArray);
    }



    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> hashedGrouping = new HashMap<>();
        for(String s:strings){
            String hash= hash(s);
            if(!hashedGrouping.containsKey(hash)){
                hashedGrouping.put(hash,new ArrayList<>());
            }
            hashedGrouping.get(hash).add(s);
        }
        return new ArrayList<>(hashedGrouping.values());
    }

    public static void main(String[] args) {
        String [] strings = {"abc","bcd","xyz"};
       // String [] strings = {"abc","bcd","acef","xyz","az","ba","a","z"};
      System.out.println(groupStrings(strings));

        //System.out.println(shiftLetter('c','d'));
    }
}
