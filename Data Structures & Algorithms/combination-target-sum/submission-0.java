class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet= new ArrayList<>();
        dfs(res,nums,0,target,subSet);
        return res;
    }
    public void dfs(List<List<Integer>> res,int[] nums,int i,int target,List<Integer> subSet)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(subSet));
            return;
        }
        if(target<0 || i>=nums.length) return;
        subSet.add(nums[i]);
        dfs(res,nums,i,target-nums[i],subSet);
        subSet.removeLast();
        dfs(res,nums,i+1,target,subSet);
        

    }
}
