class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, count = 0;
        int maxLength = 0, tempLength = 0;
        char ch = '!';
        String subStr = "";
        HashSet<Character> set = new HashSet<>();
        while(right<s.length()){
            ch = s.charAt(right);
            if(!set.contains(ch)){
                set.add(ch);
                tempLength = right - left + 1;
                maxLength = Math.max(maxLength, tempLength);
                right++;
            }
            else{
                subStr = s.substring(left, right + 1);
                count = left;
                for(char chTemp: subStr.toCharArray()){
                    if(chTemp!=ch){
                        set.remove(chTemp);
                        count++;
                    }
                    else{
                        break;
                    }
                }
                left = count + 1;
                set.remove(ch);
            }
        }
        return maxLength;
    }
}