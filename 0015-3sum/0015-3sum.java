class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int left = 0, right = 0, sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
        //since the array is sorted we skip those combinations which start with same values to avoid duplicates    
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
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
                    //we skip the 2nd element i.e left if it is same in succession to avoid duplicates
                    while(nums[left] == nums[left-1] && left<right){
                        left++;
                    }
                }
            }
        }
        return result;
    }
}