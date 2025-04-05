class Solution {

    private int maxSub(int index, int[] nums, List<Integer> dp){
        if(index == 0){
            return nums[index];
        }
        if(index < 0){
            return 0;
        }
        if(dp.get(index)!=-1) return dp.get(index);
        int pick = nums[index] + maxSub(index - 2, nums, dp);
        int notPick = 0 + maxSub(index - 1, nums, dp);
        dp.set(index, Math.max(pick, notPick)); 
        return dp.get(index);
    } 

    public int rob(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for(int n: nums){
            dp.add(-1);
        }
        return maxSub(nums.length - 1, nums, dp);
    }
}