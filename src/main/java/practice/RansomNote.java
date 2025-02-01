package practice;

public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] fromIndex = new int[26];
        for(char c : ransomNote.toCharArray()){
            int j = magazine.indexOf(c, fromIndex[c - 'a']);
            if(j == -1) return false;
            fromIndex[c-'a'] = j + 1;
        }
        return true;
    }
    public static boolean canConstruct1(String ransomNote, String magazine) {
        int [] charCount=new int[26];
        for(int i=0;i<magazine.length();i++){
            int ch=magazine.charAt(i);
            charCount[ch-97]++;
        }
        for(int i=0;i<ransomNote.length();i++){
            int ch=ransomNote.charAt(i);
            charCount[ch-97]--;
            if(charCount[ch-97]<0)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(canConstruct("c","aa"));

    }
}
