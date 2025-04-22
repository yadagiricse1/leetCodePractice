package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators {

    public static List<String> addOperators(String num, int target) {
       char [] operations = {'*','-','+'};
        List<String> results = new ArrayList<>();
        char [] numArray = num.toCharArray();
        List<String> combinations = new ArrayList<>();
        List<String> combinations2 = new ArrayList<>();
        Stack<String> stack1= new Stack<>();
        Stack<String> stack2= new Stack<>();
        char begin=numArray[0];
        for(int j=0;j<operations.length;j++){
            stack1.push(""+begin+operations[j]);
        }


        for(int i=1;i< numArray.length;i++){
            if(i!=numArray.length-1){
                while(!stack1.isEmpty()){
                    String s = stack1.pop();
                    for(int j=0;j<operations.length;j++){
                        stack2.push(s+ numArray[i] + operations[j]);
                    }
                }
                stack1=stack2;
                stack2= new Stack<>();
            } else{
                while(!stack1.isEmpty()){
                    String s = stack1.pop() + numArray[i];
                    stack2.push(s);
                }
                stack1=stack2;
                stack2= new Stack<>();
            }





        }



        return results;
    }

    public static void main(String[] args) {
        String num = "1234";
        int target=6;
        System.out.println(addOperators(num,target));

    }
}
