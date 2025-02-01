package practice;

public class BestTimetoBuyandSellStock2 {
    public static int maxProfit1(int[] prices){
        int maxProfit=0;
        int valley=prices[0];
        int peak=prices[0];
        int i=0;
        while(i<prices.length-1){

            while(i<prices.length-1&&prices[i]>=prices[i+1]) i++;
            valley=prices[i];
            while(i<prices.length-1&&prices[i]<=prices[i+1]) i++;
            peak=prices[i];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit=0;
        int length=prices.length;
        int[][] profits =new int[length][length];
        for(int i=1;i<length;i++){
            // maxProfit+=Math.max(prices[i]-prices[i-1],0) ;
            if(prices[i]>prices[i-1])
                maxProfit+=(prices[i]-prices[i-1]);
        }
        return maxProfit;

    }
    /*public static int maxProfit(int[] prices) {
        int maxProfit=0;
        int length=prices.length;
        int[][] profits =new int[length][length];
        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                profits[j][i]=Math.max(profits[j-1][i+1],prices[j]-prices[i]);

            }
            // maxProfit=Math.max(profits[j][i],maxProfit);
        }
        return maxProfit;
    }*/

    public static void main(String[] args) {
        int [] prices={7,1,5,3,6,4};
        System.out.println(maxProfit1(prices));

    }
}
