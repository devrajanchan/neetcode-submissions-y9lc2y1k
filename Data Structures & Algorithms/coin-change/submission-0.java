class Solution {
    Map<Integer,Integer> memo= new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return dfs(coins,amount)!=Integer.MAX_VALUE?dfs(coins,amount):-1;

    }
    private int dfs(int[] coins, int amount)
    {
        if(amount==0) return 0;
        int res=Integer.MAX_VALUE;
        if(memo.containsKey(amount)) return memo.get(amount);
        for(int coin:coins)
        {
            if(amount-coin>=0)
            {
                int result=(dfs(coins,amount-coin));
                
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + result);
                }
            }
        }
        memo.put(amount, res);
        return res;
    }
}
