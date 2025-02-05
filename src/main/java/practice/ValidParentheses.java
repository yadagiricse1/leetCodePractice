package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {


    public static boolean isValid(String s) {

        Map<Character,Character> parenthesesMap= new HashMap<>();
        parenthesesMap.put('}','{');
        parenthesesMap.put(']','[');
        parenthesesMap.put(')','(');

        Stack<Character> stk = new Stack<>();
        for(char ch:s.toCharArray()){

            if(parenthesesMap.containsKey(ch)){
                if(stk.isEmpty())
                    return false;
              char top=stk.pop();
                if(top!=parenthesesMap.get(ch)){
                    return false;
                }
            } else{
                stk.push(ch);
            }

        }
        return stk.isEmpty();

    }
    public static void main(String[] args) {
        String s="(]";
        System.out.println(isValid(s));


    }
}
