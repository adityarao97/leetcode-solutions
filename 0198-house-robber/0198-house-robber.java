class Solution {

    private int maxSub(int index, int[] nums, List<Integer> dp){
        //base case if index ==0 return nums[0] if <0 return 0
        if(index == 0){
            return nums[0];
        }
        if(index < 0){
            return 0;
        }
        //if value exists in dp return it
        if(dp.get(index)!=-1) return dp.get(index);
        //at each step pick the current item in array or don't
        //if we pick we will call the function with next alternate value hence index - 2 
        int pick = nums[index] + maxSub(index - 2, nums, dp);
        //if we don't pick we will call the next element in arrary with index - 1
        int notPick = maxSub(index - 1, nums, dp);
        //we take the maximum of the two decision
        dp.set(index, Math.max(pick, notPick));
        return dp.get(index);
    }

    public int rob(int[] nums) {
        //initialize a dp list with all values = -1
        List<Integer> dp = new ArrayList<>();
        for(int n: nums){
            dp.add(-1);
        }
        //call from last index a recursive function
        return maxSub(nums.length - 1, nums, dp);
    }
}