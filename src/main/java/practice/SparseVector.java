package practice;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/dot-product-of-two-sparse-vectors
public class SparseVector {

    Map<Integer,Integer> indexNums;


    SparseVector(int[] nums) {
        indexNums = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if (nums[i] != 0) {
                indexNums.put(i, nums[i]);
            }
        }

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct =0;
        Map<Integer,Integer> indexNums1 =vec.indexNums;
        for(Map.Entry<Integer,Integer> entry:indexNums1.entrySet()){
            if(indexNums.containsKey(entry.getKey())){
                dotProduct+=indexNums.get(entry.getKey())*entry.getValue();
            }
        }
        return dotProduct;
    }
  /*  int [] nums;
    SparseVector(int[] nums) {
        this.nums=nums;

    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct =0;
        int[] nums2=vec.nums;
        for(int i=0;i<nums.length;i++){
            dotProduct+=nums[i]*nums2[i];
        }
        return dotProduct;
    }*/
}
