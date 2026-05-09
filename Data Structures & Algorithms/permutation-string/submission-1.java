class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length();
        int n2=s2.length();
        if(n1>n2) return false;
        char[] c = new char[26];
        char[] b = new char[26];
        for(char i:s1.toCharArray())
        {
            c[i- 97]++;
        }
        for(int i=0;i<n2;i++)
        {
            b[s2.charAt(i)-'a']++;
            if(i>=n1)
            {
                b[s2.charAt(i-n1)-'a']--;
            }
            if(Arrays.equals(b,c)) return true;
        }
        return false;
    }
}
