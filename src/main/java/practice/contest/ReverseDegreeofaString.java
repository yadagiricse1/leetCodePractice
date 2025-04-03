package practice.contest;

public class ReverseDegreeofaString {

    public static  int reverseDegree(String s) {
        int result=0;
        for(int i=0;i<s.length();i++){
           int j=(s.charAt(i)-'a');

            result+=(26-j)*(i+1);
        }


        return result;

    }

    public static void main(String[] args) {
        String s="abc";
        System.out.println(reverseDegree(s));
    }
}
