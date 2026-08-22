class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub= new ArrayList<>();
        int l=nums.length;
        dfs(res,0,sub,nums);
        return res;

    }
    public void dfs(List<List<Integer>> res,int i,List<Integer> sub,int[] nums)
    {
        if(i==nums.length)
        {
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[i]);
        dfs(res,i+1,sub,nums);
        sub.remove(sub.size()-1);
        dfs(res,i+1,sub,nums);

    }
}
