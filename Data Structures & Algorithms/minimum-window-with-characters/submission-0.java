class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        if(t=="") return "";
        HashMap<Character,Integer> map= new HashMap<>();
        for(char c:t.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        int have=0;
        int need =map.size();
        int l=0;
        int[] ans={Integer.MAX_VALUE,0,0};
        HashMap<Character,Integer> window= new HashMap<>();
        for(int r=0;r<s.length();r++)
        {
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0)+1);
            if(map.containsKey(s.charAt(r)) && window.get(s.charAt(r)).intValue() == map.get(s.charAt(r)).intValue())
            {
                have++;
            }
            while(have==need)
            {
                if(r-l+1<ans[0])
                {
                    ans[0]=r-l+1;
                    ans[2]=r;
                    ans[1]=l;
                }
                window.put(s.charAt(l),window.get(s.charAt(l))-1);
                if(map.containsKey(s.charAt(l)) && window.get(s.charAt(l)).intValue() < map.get(s.charAt(l)).intValue())
                {
                    have--;
                }
                l++;
            }
        }
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    
        
    }
}
