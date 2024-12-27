class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String sortedString = new String(chArr);
            List<String> val = map.getOrDefault(sortedString, new ArrayList<>());
            val.add(str);
            map.put(sortedString, val);
        }
        List<List<String>> resultArr = new ArrayList<>();
        for(String key: map.keySet()){
            resultArr.add(map.get(key));
        }
        return resultArr;
    }
}