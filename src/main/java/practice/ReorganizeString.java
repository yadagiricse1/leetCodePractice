package practice;

import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganizeString(String s) {
        int strLen = s.length();
        if(strLen<=1)
            return s;
        int []charCount = new int[26];
        for(char ch:s.toCharArray()){
            charCount[ch-'a']++;
        }
        int maxCounter =0;
        int charCountLetter =0;
        for (int i = 0; i < charCount.length; i++) {
            if(charCount[i]>maxCounter){
                maxCounter=charCount[i];
                charCountLetter =i;
            }
        }

        if(maxCounter>(s.length()+1)/2)
            return "";
        char [] ans = new char[s.length()];
        int index = 0;
        while(charCount[charCountLetter] != 0){
            ans[index]=(char) (charCountLetter + 'a');
            charCount[charCountLetter]--;
            index++;
        }
        for (int i = 0; i < charCount.length; i++) {
            while(charCount[i]>0){
                if(index>=s.length()){
                    index=1;
                }
                ans[index]=(char) (i + 'a');
                charCount[i]--;
                index=index+2;
            }
        }
        return String.valueOf(ans);
    }

    public static void main(String[] args) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[1],b[1]));

    }
}
