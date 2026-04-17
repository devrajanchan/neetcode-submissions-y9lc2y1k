class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product=1;
        boolean allZeros = Arrays.stream(nums).filter(x -> x == 0).count() > 1;;
        if(allZeros){
            product=0;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                continue;
            }
            product*=nums[i];
        }
        int[] res= new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0) {
                Arrays.fill(res,0);
                res[i]=product;
                break;}
                
            else{
                res[i]=product/nums[i];
            }
            
        }
    return res;
    }
}  
