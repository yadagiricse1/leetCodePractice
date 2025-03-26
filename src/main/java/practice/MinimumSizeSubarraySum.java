package practice;

import java.util.Arrays;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums){
        int result= Integer.MAX_VALUE;
        int sum=0;
        int j=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum>=target){

                if(i-j+1<result)
                    result=i-j+1;
                sum-=nums[j];
                j++;
            }

        }
        return result!=Integer.MAX_VALUE?result:0;
    }
    public static int minSubArrayLen1(int target, int[] nums){
        int sum=0;
        int counter=0;
        int i=0;
        while(i<nums.length&&sum<target){
            sum=sum+nums[i];
            counter++;
            i++;
        }
        int min;
        int k=0;
        if(i==nums.length){
            if(sum<target)
                return 0;
            while((sum-nums[k])>=target){
                sum= sum-nums[k];
                counter--;
                k++;
            }
            return counter;
        } else {

            while((sum-nums[k])>=target){
                sum= sum-nums[k];
                counter--;
                k++;
            }
            min=counter;
            while(i<nums.length){
                sum=sum+nums[i];
                counter++;
                while((sum-nums[k])>=target){
                    sum= sum-nums[k];
                    counter--;
                    k++;
                    if(counter<min)
                        min=counter;
                }
                i++;

            }
        }
        return min;
    }

    public static void main(String[] args) {
       /* //int nums[]={1,2,3,4,5};
        int nums[]={12,28,83,4,25,26,25,2,25,25,25,12};
       // int nums[]={2,3,1,2,4,3};
        int target=213;
        //int target=11;*/
        int target=15;
        int nums[]={5,1,3,5,10,7,4,9,2,8};

        System.out.println(minSubArrayLen(target,nums));

    }
}
