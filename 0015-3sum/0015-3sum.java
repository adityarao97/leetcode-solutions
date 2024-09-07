class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0, right = 0, sum = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
        //array is sorted hence any combination with same starting value will result in duplicate, so we skip that
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //two pointer approach
            left = i + 1;
            right = nums.length - 1;
            while(left<right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum>0){
                    right--;
                }
                else if(sum<0){
                    left++;
                }
                else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while(nums[left] == nums[left-1] && left<right){
                        left++;
                    }
                }
            }
        }
        return result;
    }
}