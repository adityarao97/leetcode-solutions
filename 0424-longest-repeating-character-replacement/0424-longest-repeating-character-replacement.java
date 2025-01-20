class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int left = 0, maxLength = 0, maxF = 0;
        char ch = '#';
        for(int right = 0; right<s.length(); right++){
            ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch,0) + 1);
            maxF = Math.max(maxF, freqMap.get(ch));
            while((right - left + 1) - maxF > k){
                ch = s.charAt(left);
                freqMap.put(ch, freqMap.get(ch) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}