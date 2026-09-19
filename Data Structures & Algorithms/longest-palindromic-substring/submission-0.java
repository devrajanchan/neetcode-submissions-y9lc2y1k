class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int res = 0;    // Starts index of the longest palindrome
        int resLen = 0; // Length of the longest palindrome

        for (int i = 0; i < s.length(); i++) {
            // 1. Odd-length palindrome (center is i)
            int len1 = expandFromCenter(s, i, i);
            
            // 2. Even-length palindrome (center is between i and i + 1)
            int len2 = expandFromCenter(s, i, i + 1);

            // Get the max length found at index i
            int maxLen = Math.max(len1, len2);

            // Update result variables if a longer palindrome is found
            if (maxLen > resLen) {
                resLen = maxLen;
                // Calculate the starting index of the palindrome
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
        // Returns the length of the palindrome found: (right - 1) - (left + 1) + 1
        return right - left - 1;
    }
}