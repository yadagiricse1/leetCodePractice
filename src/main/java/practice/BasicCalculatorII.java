package practice;

import java.util.Stack;

public class BasicCalculatorII {
    public static int calculate(String s) {

        Stack<Integer> stk = new Stack<>();
        if(s==null||s.isEmpty())
            return 0;

        int currentNumber = 0;
        int len = s.length();
        char operation = '+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                currentNumber+=(currentNumber*10)+(ch-'0');
            }
            if(!Character.isDigit(ch) && !Character.isWhitespace(ch)||i==len-1){
                 if(operation=='+'){
                     stk.push(currentNumber);
                 } else if(operation=='-'){
                     stk.push(-currentNumber);
                 } else if(operation=='*'){
                     stk.push(stk.pop()*currentNumber);
                 } else if(operation=='/'){
                     stk.push(stk.pop()/currentNumber);
                 }
                currentNumber = 0;
                operation=ch;
            }

        }

        int result = 0;
        while (!stk.isEmpty()) {
            result += stk.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "3+2*5";
        System.out.println(calculate(s));

    }
}
