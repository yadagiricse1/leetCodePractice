package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSwap {
    public  static int maximumSwap(int num) {
        char[] numArr = Integer.toString(num).toCharArray();
        int n = numArr.length;
        int[] maxRightIndex = new int[n];

        maxRightIndex[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            maxRightIndex[i] = (numArr[i] > numArr[maxRightIndex[i + 1]])
                    ? i
                    : maxRightIndex[i + 1];
        }

        for (int i = 0; i < n; ++i) {
            if (numArr[i] < numArr[maxRightIndex[i]]) {
                char temp = numArr[i];
                numArr[i] = numArr[maxRightIndex[i]];
                numArr[maxRightIndex[i]] = temp;
                return Integer.parseInt(new String(numArr));
            }
        }

        return num;
    }
    public static  int maximumSwap1(int num) {
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
        int num=2736;
       //  int num=9973;
        //9973
        //4321
        //3333
        System.out.println(maximumSwap(num));

    }
}
