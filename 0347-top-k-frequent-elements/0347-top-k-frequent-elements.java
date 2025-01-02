class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //create a frequency map of each value in array key: element, value: frequency of element
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int size = nums.length+1;
        //frequency array is a list of array where each array index will contain the corresponding list of items from nums based on their frequency, eg: nums[] = [1,1,1,2,2,3,4,4,4], frequency[1] = <3>, frequency[2] = <2>, frequency[3] = <1,4>
        List<Integer>[] frequency = new ArrayList[size];
        for(int i=0; i<size;i++){
            frequency[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            frequency[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int count = 0;
        int frequencySize = frequency.length - 1;
        //the top occuring k elements can be read in reverse order of the frequency array as the highest frequency element will be stored at the last index 
        for(int i = frequencySize; i>=0; i--){
            List<Integer> temp = frequency[i];
            for(int j: temp){
                res[count++] = j;
                if(count==k){
                    return res;
                }
            }
        }
        return res;
    }
}