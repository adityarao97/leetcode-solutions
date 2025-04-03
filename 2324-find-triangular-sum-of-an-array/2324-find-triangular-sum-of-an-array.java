class Solution {
    public int triangularSum(int[] nums) {
        //solve with recursion

        //base condition if nums.size==1 return nums[0]
        if(nums.length == 1){
            return nums[0];
        }
        //create a new array with size n-1
        int[] newNums = new int[nums.length-1];
        //loop across original array
        int count = 0;
        for(int i=0; i<nums.length-1; i++){
            //find sum of 1st and 2nd element and mod it and store it in new array
            newNums[count] = (nums[i] + nums[i+1])%10;
            count++;
        }
        //call triangular sum with that new array 
        return triangularSum(newNums);
    }
}