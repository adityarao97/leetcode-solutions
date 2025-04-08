class Solution {

    public boolean canJump(int[] nums) {
        //goalpost is initially at the last index
        int goalPost = nums.length - 1;
        //we keep shifting goal post by checking if it is reachable from its previous index
        for(int i = nums.length - 2; i>=0; i--){
            if(i + nums[i] >= goalPost) goalPost = i;
        }
        //return true if goalpost is shifted to 0th index
        return (goalPost == 0);
    }
}