class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> mapST = new HashMap<Character,Character>();
        HashMap<Character,Character> mapTS = new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);
            if((mapST.containsKey(sCh) && mapST.get(sCh)!=tCh) || (mapTS.containsKey(tCh) && mapTS.get(tCh)!=sCh)){
                return false;
            }
            mapST.put(sCh, tCh);
            mapTS.put(tCh, sCh);
        }
        return true;
    }
}