package amazonPrep;

public class StockBuySell {

    public int maxProfitSimple(int[] prices) {
        int i=0,j=1;
        int max=0;
        int k;
        while(j<prices.length){
//            max=(prices[j]<prices[i]) ? i=j : Math.max(max,prices[j]-prices[i]);
//            System.out.println(max);
//            j++;

           if(prices[j]<prices[i]){
                i=j;
                j++;
            }
            else{
                max=Math.max(max,prices[j]-prices[i]);
                j++;
            }
        }
        if(i==j-1) {
            return 0;
        }
        return max;
    }


    public int maxProfitNew(int[] prices) {
        int i=0,j=1;
        int max=0;
        int maxProfit=Integer.MIN_VALUE;
        if (prices.length==1) maxProfit= 0;
        if (prices.length==2) {
            if(prices[prices.length-1]>prices[prices.length-2]){
                maxProfit= prices[prices.length-1]-prices[prices.length-2];
            }
            else{
                maxProfit=0;
            }
        }
        while(j<prices.length){
            if(j==prices.length-1){
                if(prices[j]>prices[i]){
                    maxProfit= prices[j]-prices[i];
                }
                else{
                    return maxProfit;
                }
            }
            max=prices[j]<prices[i]?i=j:Math.max(max,prices[j]-prices[i]);
            System.out.println(max);
            maxProfit=Math.max(max,maxProfit);
            if(i==prices.length-2){
                if(prices[i+1]>prices[i]){
                    return prices[i+1]-prices[i];
                }
                else{
                    maxProfit=0;
                }
            }
            j++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr={2,1,2,0,1};
       // int[] arr={7,2,5,3,6,4,0,8};
       // int[] arr={2,4,1};
        //7,6,4,3,1
        StockBuySell obj = new StockBuySell();
        System.out.println( " >>> "+ obj.maxProfitNew(arr));
    }
}
