package practice;

public class FindPeakElement {

    public  int findPeakElementRecursive(int[] nums){
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums,int begin, int end){
        if(begin==end)
            return begin;
        int mid=(begin+end)/2;
        if(nums[mid]>nums[mid+1])
            return search(nums,begin,mid);
        else
            return search(nums,mid+1,end);
    }


    public static int findPeakElementIterative(int[] nums){
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid =(l+r)/2;
            if(nums[mid]>nums[mid+1])
                r = mid;
            else
                l=mid+1;

        }
        return l;
    }

    public static int findPeakElement(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])
                return i;

        }

        return nums.length-1;

    }
    public static int findPeakElement2(int[] nums){
      int ans =0;
        for(int i=0;i<nums.length;i++){
            if((i==0||nums[i-1]<nums[i])&&(i==nums.length-1||nums[i]>nums[i+1])){
                ans =i;
                break;
            }
        }

        return ans;
    }
    public static int findPeakElement1(int[] nums) {
        if(nums.length==1)
            return nums[0];
        if(nums[0]>nums[1])
            return 0;
        else if(nums[nums.length-2]<nums[nums.length-1])
            return nums.length-1;
        else {
            for(int i=1;i<nums.length-1;i++){
                if(nums[i-1]<nums[i]&&nums[i]>nums[i+1])
                    return i;
            }

        }
        return 0;
    }



    public static void main(String[] args) {
        int [] nums ={1,2,3,1};
       // int [] nums ={1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));

    }
}
