class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length==1){
            return strs[0];
        }
        for(int i=0;i<strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i || ch!=strs[j].charAt(i)){
                    return res;
                }
            }
            res += ch;
        }
        return res;
}}