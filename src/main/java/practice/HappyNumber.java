package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public static  boolean isHappy(int n) {
        Set<Integer> repeated=new HashSet<>();
        repeated.add(n);

        while(true){
            n=digitsSumOfSquare(n);
            if(n==1)
                return true;
            else{
                if(repeated.contains(n))
                    return false;
                repeated.add(n);
            }
        }
    }

    public static int digitsSumOfSquare(int n){
        int sum=0;
        while(n>0){
            int i=n%10;
            n=n/10;
            sum+=i*i;
        }
    return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(24));

    }
}
