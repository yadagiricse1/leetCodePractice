package practice.contest;

import java.util.Arrays;

public class EatPizzas {
    public  static long maxWeight(int[] pizzas) {
        int totalDays=pizzas.length/4;
        long total= 0;
        Arrays.sort(pizzas);

            int oddCount=(totalDays+1)/2;
            int evenCount=totalDays/2;
            int startIndex=pizzas.length-1;
            while(oddCount>0){
                total+=pizzas[startIndex];
                startIndex--;
                oddCount--;
            }
            while(evenCount>0){
                startIndex--;
                total+=pizzas[startIndex];
                startIndex--;
                evenCount--;
            }
        return total;
    }

    public static void main(String[] args) {
        int [] pizzas={1,2,3,4,5,6,7,8};
        System.out.println(maxWeight(pizzas));


    }
}
