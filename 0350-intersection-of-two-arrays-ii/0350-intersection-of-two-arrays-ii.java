class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i:nums1){
            map1.put(i, map1.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            map2.put(i, map2.getOrDefault(i,0)+1);
        }
        List<Integer> list = new ArrayList<>();
        for(int key : map1.keySet()){
            if(map2.containsKey(key)){
                int times = Math.min(map1.get(key), map2.get(key));
                for(int i=0;i<times;i++){
                    list.add(key);
                }
            }
        }
        int[] res = new int[list.size()];
        int count = 0;
        for(int i=0;i<list.size();i++){
            res[count++] = list.get(i);
        }
        return res;
    }
}