package practice;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> sumIndex = new HashMap<>();
        sumIndex.put(0,-1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sumIndex.containsKey(sum%k)){
                if(i-sumIndex.get(sum%k)>1){
                    return true;
                }
            } else{
                sumIndex.put(sum%k,i);
            }
        }



        return false;

    }

    public static void main(String[] args) {
        int [] nums ={23,2,4,6,7};
        int k=6;
        System.out.println(checkSubarraySum(nums,k));

    }
}
