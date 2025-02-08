package practice;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int number=0;
        for(int i:nums)
            number=number^i;
         return number;
    }
}
