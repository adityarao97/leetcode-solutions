class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();
        if(s.equals(t) || t.isEmpty()){
            return s;
        }
        for(char ch: t.toCharArray()){
            tCount.put(ch, tCount.getOrDefault(ch,0)+1);
        }
        int minLength = s.length()+1, have = 0, needs = tCount.size();
        int[] minIndex = {-1, -1};
        int left = 0;
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0)+1);
            if(tCount.containsKey(ch) && window.get(ch).equals(tCount.get(ch))){
                have++;
            }
            while(have==needs){
                if((right - left + 1) < minLength){
                    minLength = right - left + 1;
                    minIndex[0] = left;
                    minIndex[1] = right;
                }
                char temp = s.charAt(left);
                window.put(temp, window.get(temp)-1);
                if(tCount.containsKey(temp) && window.get(temp)<tCount.get(temp)){
                    have--;
                }
                left++;
            }
        }
        if(minIndex[0] == -1 && minIndex[1] == -1){
            return "";
        }
        return s.substring(minIndex[0], minIndex[1]+1);
    }
}