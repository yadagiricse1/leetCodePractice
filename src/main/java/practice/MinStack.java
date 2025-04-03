package practice;

import java.util.Stack;

public class MinStack {
    Stack<int[]> stack = new Stack<>();
    public MinStack() {
    }

    public void push(int val) {

        if(stack.isEmpty()){
            stack.push(new int[]{val,val});
        }
        int currentMin = stack.peek()[1];
        stack.push(new int[]{val,Math.min(val,currentMin)});

    }

    public void pop() {
        if(!stack.isEmpty())
            stack.pop();

    }

    public int top() {
    return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
  /*  Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }


    public void push(int val) {
        if(val<min){
            min=val;
        }
        stack.push(val);
    }

    public void pop() {
        if(!stack.isEmpty()){
            int popedVal = stack.pop();
            if(popedVal==min){
                min = Integer.MAX_VALUE;
                Stack<Integer> temp = new Stack<>();
                while(!stack.isEmpty()){
                 int val =  stack.pop();
                 if(val<min){
                     min= val;
                 }
                    temp.push(val);
                }

                while(!temp.isEmpty()){
                    int val =  temp.pop();
                    stack.push(val);
                }
            }
        }


    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }*/
}
