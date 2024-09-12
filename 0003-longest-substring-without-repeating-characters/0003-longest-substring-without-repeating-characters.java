class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, count = 0;
        int maxLength = 0;
        char ch = '!';
        String subStr = "";
        HashSet<Character> set = new HashSet<>();
        while(right<s.length()){
            ch = s.charAt(right);
            if(!set.contains(ch)){
                set.add(ch);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            }
            else{
                subStr = s.substring(left, right + 1);
                count = 0;
                while(subStr.charAt(count)!=ch){
                    set.remove(subStr.charAt(count));
                    count++;
                }
                left = left + count + 1;
                set.remove(ch);
            }
        }
        return maxLength;
    }
}