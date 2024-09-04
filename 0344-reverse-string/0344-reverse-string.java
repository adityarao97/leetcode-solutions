class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while(left<right){
            char ch1 = s[left];
            char ch2 = s[right];
            s[left] = ch2;
            s[right] = ch1;
            left++;
            right--;
        }
    }
}