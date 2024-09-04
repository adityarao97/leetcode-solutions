class Solution {
    public boolean validPalindrome(String s) {
        if(s.length() < 3){
            return true;
        }
        //assign two pointers left = 0 and right = s.length()-1
        int left = 0;
        int right = s.length() - 1; 
        //loop for each character in the string while left < right
        while(left < right){
            //if left != right
            if(s.charAt(left)!=s.charAt(right)){
                //check validPalindromeCondition by skipping one left character by doing left++ or right--
                return isValidPalindrome(s, left+1, right) || isValidPalindrome(s, left, right-1);
            }
            left++;
            right--;
        }
        //return true
        return true;  
    }
    //write function to check valid palindrome
    public static boolean isValidPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}