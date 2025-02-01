package practice;

public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int price =prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
           /* if(prices[i]>price){
                profit=prices[i]-price;
            }else{
                price= prices[i];
            }
            maxProfit = Math.max(profit,maxProfit);*/
            price = Math.min(price,prices[i]);
            maxProfit = Math.max(prices[i]-price,maxProfit);

        }

        return maxProfit;
    }
    public static void main(String[] args) {

    }

}
