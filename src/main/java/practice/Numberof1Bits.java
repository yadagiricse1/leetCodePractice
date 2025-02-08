package practice;

public class Numberof1Bits {
    public static int hammingWeight(int n) {
        int count=0;
        while(n>0){
            if(n%2==1)
                count++;
            n=n/2;
        }
        return count;
    }

    public static void main(String[] args) {
        int n=2147483645;
        System.out.println(hammingWeight(n));
    }
}
