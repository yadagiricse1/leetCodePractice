package practice;

public class ReverseWordsinaString {

    public static String reverseWords(String s) {
        String[] words=s.trim().split(" ");
        StringBuilder sb= new StringBuilder();
        sb.append(words[words.length-1]);
        for(int i=words.length-2;i>=0;i--){
            if(!(words[i]==" "||words[i]==""))
                sb.append(" ").append(words[i]);
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String s="a good   example";
        System.out.println(reverseWords(s));

    }

}
