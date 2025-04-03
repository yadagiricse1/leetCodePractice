package practice;

import java.util.Stack;

public class SimplifyPath {

    public static  String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] directories =path.split("/");
        for(String directory:directories){

            if(directory.equals(".")||directory.isEmpty())
                continue;
            else if(directory.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            } else{
                stack.push(directory);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return !result.isEmpty() ? result.toString() : "/";

    }

    public static void main(String[] args) {

    }

}
