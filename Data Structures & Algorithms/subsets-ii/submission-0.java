class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub= new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,res,sub,0);
        return res;
    }
    private void dfs(int[] nums,List<List<Integer>> res,List<Integer> sub,int i)
    {
        if(i==nums.length)
        {
            res.add(new ArrayList<>(sub));
            return;
        }
        
        sub.add(nums[i]);
        dfs(nums,res,sub,i+1);
        sub.removeLast();
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
    i++;
}
        dfs(nums,res,sub,i+1);

    }
}
