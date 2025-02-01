package practice;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        int i=0;
        int j=1;
        int count=0;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            } else {
                i++;
                nums[i]=nums[j];
                j++;
                count++;
            }
        }

     return count;
    }
    public static void main(String[] args) {

    }
}
