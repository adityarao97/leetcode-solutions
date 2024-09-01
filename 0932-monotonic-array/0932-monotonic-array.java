class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length<=1){
            return true;
        }
        boolean monotoneIncreasing = false;
        boolean monotoneDecreasing = false;
        for(int i = 1 ; i < nums.length; i++){
            if(nums[i]>=nums[i-1]){
                monotoneIncreasing = true;
            }
            else{
                monotoneIncreasing = false;
                break;
            }
        }
        if(monotoneIncreasing){
            return true;
        }
        for(int i = 1 ; i < nums.length; i++){
                if(nums[i]<=nums[i-1]){
                    monotoneDecreasing = true;
                }
                else{
                    monotoneDecreasing = false;
                    break;
                }
        }
        if(monotoneDecreasing){
            return true;
        } 
        return false;
    }
}