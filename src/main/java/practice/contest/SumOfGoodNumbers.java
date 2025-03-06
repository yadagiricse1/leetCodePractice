package practice.contest;

public class SumOfGoodNumbers {

    public int sumOfGoodNumbers(int[] nums, int k) {
        int length=nums.length;
        int sum=0;
        for(int i=0;i<length;i++){
            int k1=i-k;
            int k2=i+k;
            if(k1>=0 && k2<length){
                if(nums[i]>nums[k1] && nums[i]>nums[k2])
                    sum+=nums[i];
            }  else if(k1<0&&k2<length){
                if(nums[i]>nums[k2])
                    sum+=nums[i];

            } else if (k1>=0 && k2>=length ){
                if(nums[i]>nums[k1])
                    sum+=nums[i];

            } else {

                sum+=nums[i];
            }

        }
        return sum;
    }
}
