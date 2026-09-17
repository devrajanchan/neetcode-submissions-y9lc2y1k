class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] cache= new int[n];
        Arrays.fill(cache,-1);
        return dfs(0,nums,cache);
    }
    private int dfs(int i,int[] nums,int[] cache)
    {
        if(i>=nums.length) return 0;
        if(cache[i]!=-1) return cache[i];
cache[i] = Math.max(nums[i] + dfs(i + 2, nums, cache), dfs(i + 1, nums, cache));
    return cache[i];
    }
}
