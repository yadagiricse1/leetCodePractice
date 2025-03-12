package practice;

public class TwoSumIIInputArrayIsSorted {

    public static int[] twoSum(int[] numbers, int target) {
     int low=0;
     int high=numbers.length-1;
     int sum;
     while(low<high){
         sum= numbers[low]+numbers[high];
         if(sum==target)
             return new int[]{low + 1, high + 1};
         else if(sum<target){
             low++;

         } else {
             high--;
         }
     }
    return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int [] numbers ={2,7,11,15};
        int target =9;
        int []result=twoSum(numbers,target);

        System.out.println(result[0]+" "+result[1]);




    }
}
