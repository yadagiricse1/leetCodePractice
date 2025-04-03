package practice.contest;

public class MinimumCosttoReachEveryPosition {
    public static int[] minCosts(int[] cost) {
        int []result = new int[cost.length];
        result[0]=cost[0];
        for(int i=1;i<cost.length;i++){
            if(result[i-1]<cost[i]){
                result[i]=result[i-1];
            } else{
                result[i]=cost[i];
            }

        }
      return result;
    }

    public static void main(String[] args) {
        int [] cost ={1,2,4,6,7};
        int []result =minCosts(cost);
        for(int k:result)
            System.out.print(k+" ");


    }
}
