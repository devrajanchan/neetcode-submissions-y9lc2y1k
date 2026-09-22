class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int res = 0;    
        int resLen = 0; 

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
      
            int len2 = expandFromCenter(s, i, i + 1);

           
            int maxLen = Math.max(len1, len2);
            if (maxLen > resLen) {
                resLen = maxLen;
               
                res = i - (maxLen - 1) / 2;
            }
        }

        return s.substring(res, res + resLen);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return right - left - 1;
    }
}