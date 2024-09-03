class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1){
            return true;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        //remove all characters such that string has only alpha numeric characters in it
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if((ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                sb.append(ch);
            }
        }
        String formattedString = sb.toString();
        //create two pointers p1 & p2 and if the string length is even p1 = mid-1 & p2 = mid else p1 = mid-1 & p2 = mid+1
        int mid = formattedString.length()/2;
        int p1 = mid - 1;
        int p2 = (formattedString.length()%2==0) ? mid : mid+1;
        //loop from 0 - mid-1, compare s[p1--] == s[p2++], if not true return false   
        for(int i = 0; i<mid;i++){
            if(formattedString.charAt(p1--)!=formattedString.charAt(p2++)){
                return false;
            }
        }
        //return true;
        return true;
    }
}