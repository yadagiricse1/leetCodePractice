package practice;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int i=digits.length-1;
        while(i>=0){
            if(digits[i]<9){
                digits[i]=digits[i]+1;
                return digits;
            }
            else {
                digits[i] = 0;
                i--;
            }
        }
        digits= new int[digits.length+1];
        digits[0]=1;
        return digits;
    }

    public static void main(String[] args) {
        int [] digits = {0,0,0};

        digits=plusOne(digits);
        for(int i: digits)
            System.out.print(i+" ");


    }
}
