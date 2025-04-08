class Solution {

    public boolean canJump(int[] nums) {
        int goalPost = nums.length - 1;
        for(int i = nums.length - 2; i>=0; i--){
            if(i + nums[i] >= goalPost) goalPost = i;
        }
        return (goalPost == 0);
    }
}