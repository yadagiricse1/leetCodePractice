package practice;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map< Integer, Integer > map = new HashMap< >();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public  static int subarraySum1(int[] nums, int k) {
        int [] subSums = new int[nums.length+1];
        if(nums.length==1 &&nums[0]==k)
            return 1;
        int counter =0;
        subSums[0]=nums[0];
        for(int i=1;i<=nums.length;i++){
            subSums[i]=subSums[i-1]+nums[i-1];
        }

        for(int i=0;i< nums.length;i++){

            for(int j=i+1;j<=nums.length;j++){
                if((subSums[j]-subSums[i])==k){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int [] nums ={1,2,1,1,2,1,1};
        int k=4;
        System.out.println(subarraySum(nums,k));

    }
}
