class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i<strs.length; i++){
            if(set.contains(i)){
                continue;
            }
            List<String> tempArr = new ArrayList<>();
            tempArr.add(strs[i]);
            for(int j = i+1; j<strs.length; j++){
                if(isAnagram(strs[i], strs[j])){
                    tempArr.add(strs[j]);
                    set.add(j);
                }
            }
            res.add(tempArr);
        }
        return res;
    }

    boolean isAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        s = new String(c1);
        t = new String(c2);
        return s.equals(t);
    }
}