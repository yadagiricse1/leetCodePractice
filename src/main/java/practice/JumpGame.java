package practice;
enum Status{
    GOOD,BAD,UNKNOWN
}
public class JumpGame {

    public static boolean canJump3(int []nums) {
    Status[] memo = new Status[nums.length];
        for(int i=0;i<nums.length;i++){
            memo[i]=Status.UNKNOWN;
        }
        memo[nums.length-1]=Status.GOOD;
        for(int i=nums.length-2;i>=0;i--){
            int futurePosition= Math.min(i+nums[i],nums.length-1);
            for(int nextPosition=i+1;nextPosition<=futurePosition;nextPosition++){
                if(memo[nextPosition]==Status.GOOD){
                    memo[i]=Status.GOOD;
                    break;
                }
            }

        }

    return memo[0]==Status.GOOD;
}




    public static boolean canJump(int []nums) {
        Status[] memo = new Status[nums.length];
        for(int i=0;i<nums.length;i++){
            memo[i]=Status.UNKNOWN;
        }
        memo[nums.length-1]=Status.GOOD;

        return checkCanJump(0,nums,memo);
    }
    private static boolean checkCanJump(int position,int []nums,Status[] memo){
        if(memo[position]!=Status.UNKNOWN){
            return memo[position] == Status.GOOD;
        }

        int finalPosition= Math.min(position+nums[position],nums.length-1);
        for(int nextPosition=position+1;nextPosition<=finalPosition;nextPosition++){
            if(checkCanJump(nextPosition,nums,memo)){
                memo[position]=Status.GOOD;
                return true;
            }

        }
        memo[position]=Status.BAD;
        return false;
    }

    public static boolean canJump1(int []nums){
        return checkCanJump1(0,nums);
    }

    private static boolean checkCanJump1(int position, int[] nums) {
        if(position==nums.length-1)
            return true;
        int futureJumps =Math.min(position+nums[position],nums.length-1) ;

        for(int nextPosition=position+1;nextPosition<=futureJumps;nextPosition++){
            if(checkCanJump1(nextPosition,nums))
                return true;
        }
        return false;
    }
    public static boolean canJumpGreedyApproach(int [] nums){
        int lastPosition=nums.length-1;
        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=lastPosition){
                lastPosition=i;
            }
        }
        return lastPosition==0;
    }

    public static void main(String[] args) {
     //   int [] nums={2,3,1,1,4};
        //int [] nums={1,0};
      //  System.out.println(canJump(nums));
        int []  nums1= new int[]{3, 2, 1, 0, 4};
        System.out.println(canJump(nums1));
    }
}
