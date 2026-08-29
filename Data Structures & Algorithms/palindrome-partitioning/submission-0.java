class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> sub = new ArrayList<>();
        dfs(res,s,sub,0);
        return res;
        
    }
    private void dfs(List<List<String>> res,String s, List<String> sub, int i )
    {
        if(i==s.length())
        {
            res.add(new ArrayList<>(sub));
            return;
        }
        for(int j=i;j<s.length();j++)
        {
            String part = s.substring(i, j + 1);
            if(checkPalindrome(part))
            {
                sub.add(part);
            dfs(res,s,sub,j+1);
            sub.remove(sub.size()-1);
            }
        }
    }
    {

    }

    private boolean checkPalindrome(String s)
        {
            char[] c=s.toCharArray();
            for(int i=0;i<c.length/2;i++)
            {
                if(c[i]!=c[c.length-1-i]) return false;
            }
            return true;
        }
}
