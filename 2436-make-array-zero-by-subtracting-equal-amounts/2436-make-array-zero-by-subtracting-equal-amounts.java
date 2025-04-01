class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        while(nums[nums.length-1]>0){
            int x = 0;
            while(nums[x]==0 && x<nums.length){
                x++;
            }
            x=nums[x];
            for(int i=0; i<nums.length; i++){
                if(nums[i]>0){
                    nums[i] = nums[i] - x;
                }
            }
            count++;
        }
        return count;
    }
}