package practice;

public class LengthofLastWord {

    public static int lengthOfLastWord1(String s) {
  /*     String [] words= s.split(" ");
        return words[words.length-1].length();*/
        int p=s.length()-1;
        while(p>=0&&s.charAt(p)==' '){
            p--;

        }
        int length=0;
        while(p>=0&&s.charAt(p)!=' '){
            p--;
            length++;
        }
        return length;

    }
    public static int lengthOfLastWord(String s){
        int p=s.length();
        int length=0;

        while(p>0){
            p--;
            if(s.charAt(p)!=' '){
                length++;
            } else if(length>0){
                return length;
            }



        }
        return length;
    }

    public static void main(String[] args) {
        String s="   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));

    }
}
