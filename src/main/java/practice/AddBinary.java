package practice;

public class AddBinary {
    public static String addBinary1(String a, String b) {

        return Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));
    }
    public static String addBinary(String a, String b) {
        int n=a.length();
        int m=b.length();
        if(n<m)
            return addBinary(b,a);
        StringBuilder sb= new StringBuilder();
        int j=m-1;
        int carry=0;
        for(int i=n-1;i>-1;i--){
           char cha= a.charAt(i);
           if(cha=='1')
               carry++;
           if(j>-1&& b.charAt(j)=='1')
               carry++;
           j--;
           if(carry%2==1)
               sb.append("1");
           else
               sb.append("0");
            carry=carry/2;

        }
        if(carry==1)
            sb.append("1");
        sb.reverse();

        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b="1";
        System.out.println(addBinary(a,b));

    }
}
