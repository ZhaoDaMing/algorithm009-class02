class Solution {
    //贪心算法，每次都卖，收益为正累加
    public int maxProfit(int[] prices) {
        int tmp =0,res=0;
        for (int i = 1; i < prices.length; i++) {
            tmp =prices[i]-prices[i-1];
            if(tmp>0) res+=tmp;
        }
        return res;
    }
}