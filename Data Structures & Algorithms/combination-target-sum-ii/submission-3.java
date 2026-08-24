class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet= new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res,candidates,0,target,subSet);
        return res;
    }
    public void dfs(List<List<Integer>> res,int[] nums,int i,int target,List<Integer> subSet)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(subSet));
            return;
        }
        for(int j=i;j<nums.length;j++)
        {
            if(nums[i]>target) break;
            if(j>i && nums[j]==nums[j-1]) continue;
            subSet.add(nums[j]);
            dfs(res, nums, j + 1, target - nums[j], subSet); 
            subSet.removeLast();
        }

    }
}
