class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n)+1);
            }
            else{
                map.put(n, 1);
            }
            if(map.get(n)>Math.ceil(nums.length/2)){
                return n;
            }
        }
        return 0;
    }
}