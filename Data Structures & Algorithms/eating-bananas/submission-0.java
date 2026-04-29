class Solution {
    public int cal(int k,int[]piles)
    {
        int count=0;
        for(int i=0;i<piles.length;i++)
        {
            count+=Math.ceil((piles[i] + k - 1) / k);
        }
        return count;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n =piles.length;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        if(h==n) return high;
        int low =1;
        int k=high;
        while(low<=high)
        {
            int mid= low +(high-low)/2;
            if(cal(mid,piles)<=h)
            {
                k = mid;
                high = mid - 1;
            }
            else  low=mid+1;
        }
        return k;
    }
}
