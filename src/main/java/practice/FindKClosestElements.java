package practice;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x){
        List<Integer> results = new ArrayList<>();
        if(arr.length==k){
            for(int i=0;i< arr.length;i++){
                results.add(arr[i]);
            }
            return results;
        }

        int left=0;
        int right=arr.length-1;

        while(left<right){
            int mid =(left+right)/2;
            if(x-arr[mid]>arr[mid+k]-x){
                left = mid + 1;
            } else {
                right =mid;
            }
        }

        for (int i = left ; i < left+k; i++) {
            results.add(arr[i]);
        }

        return results;

    }
    public static List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> results = new ArrayList<>();


        if(arr.length==k){
            for(int i=0;i< arr.length;i++){
                results.add(arr[i]);
            }
           return results;
        }
        int left=0;
        int right=arr.length-1;

        while(left<right){
            int mid =(left+right)/2;
            if(arr[mid]>=x){
                right =mid;

            } else {
                left = mid + 1;
            }
        }

       left-=1;
       right=left+1;

       while(right-left-1<k){

           if(left==-1){
               right++;
               continue;
           }

         if(right==arr.length-1||Math.abs(arr[left]-x)<Math.abs(arr[right]-x)){
             left--;
         } else{
             right++;
         }
       }
        for (int i = left + 1; i < right; i++) {
            results.add(arr[i]);
        }


        return results;
    }

    public static void main(String[] args) {
        int [] arr={1,2,3,4,5,6,7,8,9,10,11,12,13};
        int k=5;
        int x=8;
        System.out.println(findClosestElements(arr,k,x));
    }
}
