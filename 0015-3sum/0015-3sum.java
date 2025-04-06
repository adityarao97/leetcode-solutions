class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //sort the array 0(nlogn)
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = n - 1;
        for(int i=0; i < n; i++){
            //if adjacent elements are same it would lead to duplicate triplets hence we skip over them
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            left = i + 1;
            right = n - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    //we'd want to check again if we encounter same values at left index to ignore duplicates
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
                //if sum is more than zero we'd want to reduce the sum by decreasing right pointer
                else if(sum > 0) right--;
                //if sum is less than 0 we'd want to increase the sum by increasing the left pointer
                else left++;
            }
        }
        return result;
    }
}
