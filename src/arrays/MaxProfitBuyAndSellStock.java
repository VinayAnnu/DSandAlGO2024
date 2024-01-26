package arrays;

public class MaxProfitBuyAndSellStock {
    private static int bestTimeToBuyAndSellStock(int[] prices) {
        int profit=0,min=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            profit=Math.max(prices[i]-min,profit);
        }
        return profit;
    }
    public static void main(String[] args) {
        int res = bestTimeToBuyAndSellStock(new int[]{7, 1, 5, 4, 3, 6});
        System.out.println(res);
    }
}
