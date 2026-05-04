class Solution {
    public int maxProfit(int[] prices) {
        int min_val=prices[0];
        int profit=0;
        for (int i : prices) {
            min_val = i < min_val? i : min_val;
            profit = profit < (i - min_val)? (i - min_val) : profit;
        }
        return profit;
    }
}
