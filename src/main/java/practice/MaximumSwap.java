package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSwap {
    public static  int maximumSwap(int num) {
        if(num%10==num)
            return num;
        int temp =num;
        List<Integer> nums = new ArrayList<>();

        while(temp>0){
            nums.add(temp%10);
            temp=temp/10;
        }
        int[] array = new int[nums.size()];
        int [] arrayCopy =new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            array[i] = nums.get(i);
            arrayCopy[i] = nums.get(i);
        }

        Arrays.sort(array);
        int j=array.length-1;
        while(j>=0){
            if(array[j]==arrayCopy[j]){
                j--;
            } else
                break;

        }
        if(j==-1)
            return num;
        for(int i=0;i<array.length;i++){
            if(array[j]==arrayCopy[i]){
                int tempval =arrayCopy[i];
                arrayCopy[i] =arrayCopy[j];
                arrayCopy[j] = tempval;
                break;
            }
        }
        int finalNum = 0;
        int i=arrayCopy.length-1;
        while(i>=0){
            finalNum=finalNum*10+arrayCopy[i];
            i--;
        }
        return finalNum;
    }

    public static void main(String[] args) {
        int num=3333;
        System.out.println(maximumSwap(num));

    }
}
