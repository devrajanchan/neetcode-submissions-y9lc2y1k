class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", ""); 
        char[] c =s.toCharArray();
        int length=c.length;

           int i=0;
           int j=length-1;
           while(i<j)
           {
            if(c[i]!=c[j])
            {
                return false;
            }
            i++;
            j--;
           }

        return true;
        
    }
}
