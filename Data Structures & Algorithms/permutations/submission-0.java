class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();
        boolean[] bool = new boolean[nums.length];
        dfs(nums,res,subSet,bool);
        return res;
        
    }
    private void dfs(int[] nums,List<List<Integer>> res,List<Integer> subSet,boolean[] bool)
    {
        if(subSet.size()==nums.length)
        {
            res.add(new ArrayList<>(subSet));
            return;
        }
        for(int j=0;j<nums.length;j++)
        {
            if(bool[j]==true) continue;
            subSet.add(nums[j]);
            bool[j]=true;
            dfs(nums,res,subSet,bool);
            subSet.removeLast();
            bool[j]=false;
        }

    }
}
