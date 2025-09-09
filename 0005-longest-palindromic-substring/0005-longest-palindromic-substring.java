class Solution {

    public void checkPalindrome(String s, int l, int r, int[] resIdx, int[] resLen){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 > resLen[0]){
                    resLen[0] = r - l + 1;
                    resIdx[0] = l;
                }
                l--;
                r++;
            }
    }

    public String longestPalindrome(String s) {
        int[] resIdx = new int[1];
        int[] resLen = new int[1];
        for(int i=0; i < s.length(); i++){
            checkPalindrome(s, i, i, resIdx, resLen);
            checkPalindrome(s, i, i+1, resIdx, resLen);
        }
        return s.substring(resIdx[0], resIdx[0] + resLen[0]);
    }
}