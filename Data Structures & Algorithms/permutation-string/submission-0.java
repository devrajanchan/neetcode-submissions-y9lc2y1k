class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        if(n1>n2) return false;
        char[] c = new char[26];
        for(char i:s1.toCharArray())
        {
            c[i- 97]+=1;
        }
        int l=0,r=n1-1;
        while(r<n2)
        {
            char[] b = new char[26];
            for(int i=l;i<=r;i++)
            {
                b[s2.charAt(i)-97]+=1;
            }
            if(Arrays.equals(b,c)) return true;
            else {l++;r++;}
        }
        return false;
    }
}
