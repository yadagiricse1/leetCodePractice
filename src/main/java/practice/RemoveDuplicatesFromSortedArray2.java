package practice;

public class RemoveDuplicatesFromSortedArray2 {
    public static int removeDuplicates1(int[] nums) {
        int i=0;
        int k=0;
        while(i<nums.length){
            if(i+1<nums.length && nums[i]==nums[i+1]){
                int j=i;
                while(nums[i]==nums[i+1]){
                    i++;
                    if(i==nums.length-1){
                        break;
                    }

                }
                if(i-j>=1){
                    nums[k]=nums[i];
                    nums[k+1]=nums[i];
                    i++;
                    k=k+2;
                }



            } else{
                nums[k]=nums[i];
                k++;
                i++;
            }

        }
        return k;
    }

    // with  clean code
    public static int removeDuplicates(int[] nums){
        if(nums.length==0)
            return 0;
     int i=1;
     int j=1;
     int count =1;
     while(i<nums.length){
         if(nums[i]==nums[i-1]){
             count++;
              if(count>2){
                  i++;
                  continue;
              }
         } else {
             count=1;
         }
         nums[j]=nums[i];
         i++;
         j++;
     }

        return j;
    }


    public static void main(String[] args) {
        //int nums[]={0,0,1,1,1,1,2,3,3};
        int nums[]={1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
        for(int i:nums)
            System.out.print(i+" ");
    }
}
