class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        boolean ans =false;
        for(int i =0;i< nums.length -1 ;i++)
        {
            int j=i+1;
            if(nums[i]==nums[j]){
                ans = true;
            }

        }
    return ans;
    }
}