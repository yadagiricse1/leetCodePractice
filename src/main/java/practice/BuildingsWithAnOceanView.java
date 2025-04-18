package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class BuildingsWithAnOceanView {
    public static int[] findBuildings(int[] heights) {
        int length=  heights.length;
        List<Integer> indices = new ArrayList<>();
        indices.add(length-1);
        int max = heights[length-1];
        for(int i=heights.length-2;i>=0;i--){
            if(max<heights[i]){
                max=heights[i];
                indices.add(i);
            }
        }
        int size=indices.size();
        int[] results = new int[size];
        for (int i = 0; i < indices.size(); i++) {
            results[size-i-1] = indices.get(i);
        }
        return results;

    }

    public static int[] findBuildings1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int length=  heights.length;
        stack.push(heights[length-1]);
        List<Integer> indices = new ArrayList<>();
        indices.add(length-1);
        for(int i=heights.length-2;i>=0;i--){
            if(stack.peek()<heights[i]){
                stack.push(heights[i]);
                indices.add(i);
            }
        }
        int size=indices.size();
        int[] results = new int[size];
        for (int i = 0; i < indices.size(); i++) {
            results[size-i-1] = indices.get(i);
        }
        return results;

    }

    public static void main(String[] args) {
        int [] heights ={4,2,3,1};
        int [] results= findBuildings(heights);
        for(int i:results)
            System.out.println(i);

    }
}
