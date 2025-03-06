package practice;

public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf1(int[] nums){
        int [] results=new int[nums.length];
         results[0]=nums[0];
         for(int i=1;i<nums.length;i++){
             results[i]= results[i-1]*nums[i];
         }
         int suffix=1;
        for(int i=nums.length-1;i>0;i--){
            results[i]=results[i-1]*suffix;
            suffix*=nums[i];
        }

        results[0]=suffix;
        return results;
    }
    public static int[] productExceptSelf(int[] nums) {
        int noOfZeros=0;
        int zeroAtIndex=-1;

        long product=1;
        int []results=new int[nums.length];
         for(int i=0;i< nums.length;i++){
             int num=nums[i];
             if(num==0){
                 noOfZeros++;
                 zeroAtIndex=i;
             } else {
                 product=product*num;
             }
             if(noOfZeros>1)
                 return results;
         }
        if(noOfZeros==1){
            results[zeroAtIndex]=(int)product;
        } else {
            for(int i=0;i< nums.length;i++){
                results[i]=(int)(product/nums[i]);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        int[] nums={2,4,2,3,2};
        int []results =productExceptSelf(nums);
        for(int i:results)
            System.out.print(i+" ");
        System.out.println();
        results =productExceptSelf1(nums);
        for(int i:results)
            System.out.print(i+" ");
    }
}
