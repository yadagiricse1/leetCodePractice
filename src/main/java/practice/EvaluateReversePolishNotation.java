package practice;

import java.util.Stack;
import java.util.regex.Pattern;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> tokenStack = new Stack<>();
        String operations = "/+-*";
        for(String token:tokens){
            if(operations.contains(token)){
                int b =tokenStack.pop();
                int a =tokenStack.pop();
                int c = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> throw new IllegalStateException("Unexpected value: " + token);
                };
                tokenStack.push(c);

            } else {
                tokenStack.push(Integer.valueOf(token));
            }
        }
        return tokenStack.pop();

    }


    public static int evalRPN1(String[] tokens) {
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Stack<String> tokenStack = new Stack<>();
        for(String token:tokens){
            if(pattern.matcher(token).matches()){
                tokenStack.push(token);
            } else {
                int a =Integer.parseInt(tokenStack.pop());
                int b =Integer.parseInt(tokenStack.pop());
                int c = 0;
                if(token.equals("+")){
                    c=(b+a);

                } else if(token.equals("-")){
                    c=(b-a);

                } else if(token.equals("*")){
                    c=b*a;
                } else if(token.equals("/")){
                    c=b/a;
                }
                tokenStack.push(String.valueOf(c));
            }
        }
    return Integer.parseInt(tokenStack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        System.out.println(evalRPN(tokens));
    }
}
