class Solution {

    public int checkPalindrome(String s, int l, int r, int res){
        res = 0;
        while (l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                res++;
                l--;
                r++;
            }
        return res;
    }

    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0; i<s.length(); i++){
            res += checkPalindrome(s, i, i, res);
            res += checkPalindrome(s, i, i + 1, res);
        }
        return res;
    }
}