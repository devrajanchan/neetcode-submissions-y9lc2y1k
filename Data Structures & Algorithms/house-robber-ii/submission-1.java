class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n = nums.length;
        int[] first=Arrays.copyOfRange(nums,0,n-1);
        int[] second=Arrays.copyOfRange(nums,1,n);
        int[] cache1= new int[n-1];
        int[] cache2= new int[n-1];
        Arrays.fill(cache1,-1);
        Arrays.fill(cache2,-1);
        return Math.max(dfs(0,first,cache1),dfs(0,second,cache2));
    }
    private int dfs(int i,int[] nums,int[] cache)
    {
        if(i>=nums.length) return 0;
        if(cache[i]!=-1) return cache[i];
cache[i] = Math.max(nums[i] + dfs(i + 2, nums, cache), dfs(i + 1, nums, cache));
    return cache[i];
    }
}
