package practice;

public class FindFirstandLastPositionofElementinSortedArray {

    public  static int[] searchRange(int[] nums, int target) {
        if(nums.length==0)
            return new int[]{-1,-1};

        int left =0;
        int right=nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                int first = mid;
                int last  = mid;

                while(first>0 && nums[first-1]==target){
                    first--;
                }
                while(last<nums.length-1 && nums[last+1]==target){
                    last++;
                }
                return new int[]{first,last};
            } else if(nums[mid]<target){
                left=mid+1;
            } else{
                right = mid-1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int [] nums ={5,7,7,8,8,10};
        int target = 100;
        int [] result = searchRange(nums,target);
        System.out.println(result[0]+" "+result[1]);

    }
}
