class Solution {
    public int minimumOperations(int[] nums) {
        //return total number of unique non zero elements
        Set<Integer> set = new HashSet<Integer>();
        for(int num: nums){
            if(num>0){
                set.add(num);
            }
        }
        return set.size();
    }
}