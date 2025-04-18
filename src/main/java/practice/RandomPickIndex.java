package practice;

import java.util.*;

public class RandomPickIndex {

    Map<Integer, List<Integer>> numIndexMap;
    Random random;

    public RandomPickIndex(int[] nums) {
        random=new Random();
        numIndexMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!numIndexMap.containsKey(nums[i])){
                numIndexMap.put(nums[i], new ArrayList<>());
            }
            numIndexMap.get(nums[i]).add(i);
        }

    }

    public int pick(int target) {
        List<Integer> indices = numIndexMap.get(target);
        return indices.get(random.nextInt(indices.size()));

    }
}
