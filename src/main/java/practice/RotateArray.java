package practice;

public class RotateArray {

    public void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    //Approach 3 Cyclic
    public void rotate(int[] nums, int k){
        int length=nums.length;
        k=k%length;
        int count=0;
        for(int start =0;count<length;start++){

            int current = start;
            int previous=nums[start];
            do
            {
                int next=(current+k)%length;
                int temp= nums[next];
                nums[next]=previous;
                previous=temp;
                current=next;
                count++;


            }while(start!=current);

        }


    }

    public void rotate2(int[] nums, int k){
        int length=nums.length;
        k=k%length;
        if(k>0&&length>1){
            for(int i=0;i<length/2;i++){
                int temp = nums[i];
                nums[i]=nums[length-i-1];
                nums[length-i-1]=temp;
            }
            for(int i=0;i<k/2;i++){
                int temp = nums[i];
                nums[i]=nums[k-i-1];
                nums[k-i-1]=temp;
            }
            for(int i=k;i<(length+k)/2;i++){
                int temp = nums[i];
                nums[i]=nums[length+k-i-1];
                nums[length+k-i-1]=temp;
            }
        }

    }
    // the below code is timing out for large array size and large k size.
    public void rotate1(int[] nums, int k) {
        int length=nums.length;
        k=k%length;
        if(k!=0){
            while(k>0){
                int i=0;
                int nextIndex=(i+1)%length;
                int next2Index=(i+2)%length;
                int temp=nums[nextIndex];//2
                int temp2=nums[next2Index];//3
                nums[nextIndex]=nums[i];
                i=1;
                for(;i<length;i++){
                    nextIndex=(i+1)%length;
                    next2Index=(i+2)%length;
                    nums[nextIndex]=temp;
                    temp=temp2;
                    temp2=nums[next2Index];
                }
                k--;
            }

        }

    }
}
