class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] v=new boolean[128];
        int left=0,right=0;
        int n = s.length();
        int res=0;
        while(right<n)
        {
            while(v[s.charAt(right)]==true)
            {
                v[s.charAt(left)]=false;
                left++;
            }
            v[s.charAt(right)]=true;
            res=Math.max(res,(right-left+1));
            right++;
        }
        return res;
    }
}
