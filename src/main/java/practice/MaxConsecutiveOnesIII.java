package practice;

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right;
        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }

            if (k < 0) {
                k += 1 - nums[left];
                left++;
            }
        }
        return right - left;
    }

// wrong solution
    public static int longestOnes1(int[] nums, int k) {

        int maxCount=0;
        for(int i=0;i<nums.length;i++){
             int k1=k;
            int j=i;
            int count=0;
            for(;j<nums.length;j++){
                if(nums[j]==1){
                    count++;
                } else {
                    if(k1>0){
                       k1--;
                       count++;
                    } else {
                        i=j-k;
                        while(nums[i]==0)
                            i++;
                         i--;
                        while(nums[i]==1){
                            i--;
                        }
                        break;
                    }
                }
            }
            maxCount =  Math.max(count,maxCount);

        }
        return maxCount;

    }

    public static void main(String[] args) {
       /* int [] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k=3;*/
        int [] nums = {0,1,1,1,1,0,0,0,1,1,1,0};
        int k=2;

       /* int [] nums = {1,0,0,0,1,1,0,0,1,1,0,0, 0,0,0,0,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,1,1,0,1,1};
        int k=8;*/
        System.out.println(longestOnes(nums,k));

    }
}
