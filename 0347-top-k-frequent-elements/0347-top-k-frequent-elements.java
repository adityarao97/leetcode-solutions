class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for(Map.Entry<Integer, Integer> entry: list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        int[] res = new int[k];
        int count = 0;
        for(Integer key: sortedMap.keySet()){
            res[count++] = key;
            if(count>=k){
                break;
            }
        }
        return res;
    }
}