package practice;

import java.util.Arrays;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length / 2;

        return nums[length];
    }
    public static void main(String[] args) {

    }
}
