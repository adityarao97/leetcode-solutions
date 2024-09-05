class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //put elements in a frequency map -> map
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int size = nums.length; 
        for(int i=0; i < size; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        //initialize a list with size n from 0 to n
        List<Integer>[] list = new ArrayList[size + 1];
        //fill outer list with indexes from 0->nums.length
        for(int i=0;i<size+1;i++){
            list[i] = new ArrayList<>();
        }
        //loop across map and based on value insert in list as 
            //list.add<map.getValue(i+1), list.get(i).add(map.getKey(i))>
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int frequency = entry.getValue();
            list[frequency].add(entry.getKey());
        }
        //initialize an array with size as k
        int[] res = new int[k];
        int count = 0;
        //loop through list in reverse order by decreasing k until it is 0 and add in result array
        for(int i = list.length - 1; i>= 0 ; i--){
            List<Integer> freq = list[i];
            for(int num: freq){
                res[count++] = num;
                if(count==k){
                    return res;
                }
            }
        }
        return new int[0];
    }
}