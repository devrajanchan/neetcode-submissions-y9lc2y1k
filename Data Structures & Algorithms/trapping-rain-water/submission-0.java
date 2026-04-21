class Solution {
    public int trap(int[] height) {
        int l=height.length;
        int[] premax = new int[l];
        int[] postmax = new int[l];
        premax[0]=0;
        postmax[l-1]=0;
        int max=0;
        for(int i=1;i<l;i++)
        {
            max=Math.max(max,height[i-1]);
            premax[i]=max;
        }
        max=0;
        for(int i=l-2;i>=0;i--)
        {
            max=Math.max(max,height[i+1]);
            postmax[i]=max;
        }
        int count=0;
        for(int i=1;i<l;i++)
        {
            if(height[i]<premax[i]&&height[i]<postmax[i])
            {
                count+=(Math.min(premax[i],postmax[i]))-height[i];
            }
            else continue;
        }
        return count;
    }
}
