class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        String[] sArr = s.split(" ");
        if(sArr.length!=pattern.length()){
            return false;
        }
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            String str = sArr[i];
            if((map1.containsKey(ch) && !map1.get(ch).equals(sArr[i])) || (map2.containsKey(str) && !map2.get(str).equals(ch))){
                return false;
            }
            else{
                map1.put(ch, sArr[i]);
                map2.put(sArr[i], ch);
            }
        }
        return true;
    }
}