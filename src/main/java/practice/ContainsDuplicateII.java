package practice;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII {
    public static boolean containsNearbyDuplicate(int[] nums, int k){
        Map<Integer, Integer> numIndices= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!numIndices.containsKey(nums[i])){
                numIndices.put(nums[i],i);
            } else{
               int prevIndex=numIndices.get(nums[i]);
               if((i-prevIndex)<=k)
                   return true;
               else{
                   numIndices.put(nums[i],i);
               }
            }

        }
        return false;
    }

    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, List<Integer>> numIndices= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!numIndices.containsKey(nums[i])){
                numIndices.put(nums[i],new ArrayList<>());
            }
            numIndices.get(nums[i]).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry:numIndices.entrySet()){
           List<Integer> indices=  entry.getValue();
           if(indices.size()>1){
               for(int i=0;i<indices.size()-1;i++){
                   if( (indices.get(i+1)-indices.get(i))<=k)
                       return true;
               }
           }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums={1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,3));

    }
}
