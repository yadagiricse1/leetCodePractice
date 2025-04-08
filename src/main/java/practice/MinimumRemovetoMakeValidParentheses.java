package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] original = s.toCharArray();
        int deleteCount = 0;
        for(int i=0; i<original.length;i++) {
            char c = original[i];
            if(c == '(') {
                stack.push(i);
            } else if(c == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    original[i] = '\0';
                    deleteCount++;
                }
            }
        }

        while(!stack.isEmpty()) {
            int index = stack.pop();
            original[index] = '\0';
            deleteCount++;
        }
        char[] result = new char[original.length - deleteCount];
        int r=0;
        for(int i=0; i<original.length; i++) {
            if(original[i] != '\0') {
                result[r++] = original[i];
            }
        }

        return new String(result);
    }




    public String minRemoveToMakeValid1(String s) {
        List<Integer> removeIndexes = new ArrayList<>();
        Stack<Integer> indexesToConsider = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                indexesToConsider.push(i);
            } else if(s.charAt(i)==')'){
                if(indexesToConsider.isEmpty()){
                    removeIndexes.add(i);
                } else{
                    indexesToConsider.pop();
                }
            }
        }
        while(!indexesToConsider.isEmpty()){
            removeIndexes.add(indexesToConsider.pop());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(!removeIndexes.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
