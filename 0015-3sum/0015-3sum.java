class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0, right = 0, sum=0, len = nums.length;
        for(int i=0; i<len;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            left = i+1;
            right = len-1;
            while(left<right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum==0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }
                else if(sum>0){
                    right--;
                }
                else{
                    left++;
                }
            }
        } 
        return res;
    }
}