package practice;

import java.util.*;

public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        if(k==nums.length)
            return nums;
        Map<Integer,Integer> numCount = new HashMap<>();
        for(int num:nums){
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(numCount::get));
        for(int num:numCount.keySet()){
            heap.add(num);
            if(heap.size()>k)
                heap.poll();
        }
        int []topNums = new int[k];
        for(int i=0;i<k;i++){
            topNums[i]=heap.poll();
        }

        return topNums;
    }

    public static void main(String[] args) {
        int []nums={1,1,1,2,2,3};
        int k=2;
        topKFrequent(nums,k);

    }
}
