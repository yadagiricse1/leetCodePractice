package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
    public static  int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> stack=new Stack<>();
        String [] s =  logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int prev=Integer.parseInt(s[2]);

        int i=1;
        while(i<logs.size()){
            s = logs.get(i).split(":");

            if(s[1].equals("start")){
                if(!stack.isEmpty())
                    result[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev=Integer.parseInt(s[2]);
            } else{
                result[stack.peek()] += Integer.parseInt(s[2]) - prev+1;
                stack.pop();
                prev=Integer.parseInt(s[2])+1;
            }
            i++;
        }

        return result;
    }

    public static  int[] exclusiveTime1(int n, List<String> logs) {
      int result[] = new int[n];
      Stack<Integer> stack=new Stack<>();
      String [] s =  logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int time=Integer.parseInt(s[2]);

        int i=1;
        while(i<logs.size()){
          s = logs.get(i).split(":");
          while(time<Integer.parseInt(s[2])){
              result[stack.peek()]++;
              time++;
          }
          if(s[1].equals("start")){
              stack.push(Integer.parseInt(s[0]));
          } else{
              result[stack.peek()]++;
              time++;
              stack.pop();
          }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("0:start:2");
        logs.add("0:end:5");
        logs.add("0:start:6");
        logs.add("0:end:6");
        logs.add("0:end:7");
        exclusiveTime(1,logs);
        System.out.println();



    }
}
