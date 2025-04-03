package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;

        Set<Integer> num_set = new HashSet<>();
        int maxLogSequence =0;
        int logSequence =0;
        for(int num:nums){
            num_set.add(num);
        }
        for(int num:num_set){
            if (!num_set.contains(num - 1)) {
                int currentNum =num;
                logSequence = 1;

                while(num_set.contains(currentNum+1)){
                    currentNum=currentNum+1;
                    logSequence+=1;

                }

                maxLogSequence =  Math.max(maxLogSequence,logSequence);

            }
        }

        return maxLogSequence;
    }
    public int longestConsecutive1(int[] nums) {
        if(nums.length==0)
            return 0;

        int maxLogSequence =1;
        int logSequence =1;
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i-1]+1==nums[i]){
                    logSequence+=1;
                    maxLogSequence= Math.max(maxLogSequence,logSequence);

                } else {
                    logSequence =1;
                }
            }

        }
        return Math.max(maxLogSequence,logSequence);
    }

    public static void main(String[] args) {
        int [] nums ={100,4,200,1,3,2};

        System.out.println(longestConsecutive(nums));


    }
}
