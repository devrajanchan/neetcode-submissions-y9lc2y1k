class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            count+=expandCenter(i,i+1,s);
            count+=expandCenter(i,i,s);
        }
        return count;
    }
    private int expandCenter(int i,int j,String s)
    {
        int count=0;
        while(i>=0&&j<s.length()&&s.charAt(i)==s.charAt(j))
        {
            count++;
            i--;
            j++;
        }
        return count;
    }
}
