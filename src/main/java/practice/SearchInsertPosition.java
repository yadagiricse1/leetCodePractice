package practice;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        return searchInsert(nums,0,nums.length-1,target);
    }
    public static int searchInsert(int[] nums, int begin,int end, int target){
        if(begin<=end){
            int mid=begin+(end-begin)/2;
            if(nums[mid]==target)
                return mid;
            else if(target<nums[mid]){
                return searchInsert(nums,begin,mid-1,target);
            } else {
                return searchInsert(nums,mid+1,end,target);
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        int nums[]={1,3,5,6};
        int target=7;
        System.out.println(searchInsert(nums,target));
    }
}
