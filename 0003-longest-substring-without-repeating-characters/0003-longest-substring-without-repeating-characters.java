class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count = 0, left = 0, result = 0;
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            while(set.contains(c)){
                set.remove(s.charAt(left));
                left++;
                count--; 
            }
            set.add(c);
            count++;  
            result = Math.max(result, count);  
        }
        
        return result;
    }
}