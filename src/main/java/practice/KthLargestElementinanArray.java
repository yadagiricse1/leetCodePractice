package practice;

import java.util.PriorityQueue;
import java.util.*;


public class KthLargestElementinanArray {


    public static int findKthLargest(int[] nums, int k) {
        /*Arrays.sort(nums);
        return nums[nums.length-k];*/
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums) {
            queue.add(num);
            if(queue.size()>k)
                queue.poll();



        }

        return queue.peek();
    }
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthLargest(nums,k));
    }
}
