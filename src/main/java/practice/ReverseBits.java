package practice;

public class ReverseBits {
    public static int reverseBits(int n) {
        String s=  Integer.toBinaryString(n);
        //String s="11111111111111111111111111111101";
        int noOfZeros=32-s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        sb.append("0".repeat(noOfZeros));
        System.out.println(sb.toString());
        return Integer.parseUnsignedInt(sb.toString(),2);
    }

    public static void main(String[] args) {
        int n=43261596;
        //reverseBits(n);
        System.out.println(reverseBits(n));
    }
}
