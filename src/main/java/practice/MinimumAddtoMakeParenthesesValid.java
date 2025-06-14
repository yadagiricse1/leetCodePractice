package practice;

public class MinimumAddtoMakeParenthesesValid {


    public static int minAddToMakeValid(String s) {
        int openBrackets=0;
        int minAddsRequired =0;
        for(char ch:s.toCharArray()){

            if(ch=='('){
                openBrackets++;
            } else{
                if(openBrackets>0)
                    openBrackets--;
                else
                    minAddsRequired++;
            }
        }

        return minAddsRequired+openBrackets;

    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s));

    }
}
