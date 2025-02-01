package practice;

public class CountPartitionswithEvenSumDifference {
    public static int countPartitions(int[] nums) {
        int count=0;
        int sum=0;
        for(int i:nums)
            sum+=i;

        if(sum%2!=0){
            return 0;
        } else{
            int leftSum=0;
            for(int j=0;j<nums.length;j++){
              sum=sum-nums[j];
                leftSum+=nums[j];
                if(Math.abs(leftSum-sum)%2==0)
                    count++;
            }

        }
        return count;

    }

    public static void main(String[] args) {
        int []  nums1= new int[]{10,10,3,7,6};
        System.out.println(countPartitions(nums1));

    }
}
