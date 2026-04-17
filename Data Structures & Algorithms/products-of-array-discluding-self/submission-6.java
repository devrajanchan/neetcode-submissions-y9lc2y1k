class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pre = new int [nums.length];
        int[] post = new int [nums.length];
        for(int i=1;i<nums.length;i++)
        {
            pre[0]=1;
            pre[i]=pre[i-1]*nums[i-1];
        }
        for(int j=nums.length-2;j>=0;j--)
        {
            post[nums.length-1]=1;
            post[j]=post[j+1]*nums[j+1];
        }
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            res[i]=pre[i]*post[i];
        }
       return res;
    }
}  
