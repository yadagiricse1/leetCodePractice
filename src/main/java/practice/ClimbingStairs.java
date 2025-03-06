package practice;

public class ClimbingStairs {
    public static int climbStairs(int n) {
       int [] combinations =new int[n+1];
        combinations[0]=0;
        combinations[1]=1;
        combinations[2]=2;
        for(int i=3;i<n+2;i++)
            combinations[i]=combinations[i-1]+combinations[i-2];
        return combinations[n];

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));

    }
}
