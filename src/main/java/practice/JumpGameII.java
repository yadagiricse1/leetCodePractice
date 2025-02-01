package practice;

public class JumpGameII {

    public static int minJumpCount(int[] nums){
        int count=0;
        int lastPosition=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=lastPosition){
                lastPosition=i;
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
          // int [] nums={2,3,1,1,4};
       // int [] nums={2,3,0,1,4};
        //int [] nums={2};
        int [] nums={1,1,1,1};

          System.out.println(minJumpCount(nums));
        //int []  nums1= new int[]{3, 2, 1, 0, 4};
      //  System.out.println(canJump(nums1));
    }
}
