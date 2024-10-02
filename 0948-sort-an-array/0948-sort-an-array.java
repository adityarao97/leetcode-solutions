class Solution {

    private static void merge(int[] nums, int left, int mid, int right){
        int p1 = left;
        int p2 = mid + 1;
        int count = 0;
        int[] temp = new int[nums.length];
        while(p1<=mid && p2<=right){
            if(nums[p1]<nums[p2]){
                temp[count++] = nums[p1++];
            }
            else{
                temp[count++] = nums[p2++];
            }
        } 
        while(p1<=mid){
            temp[count++] = nums[p1++];
        }
        while(p2<=right){
            temp[count++] = nums[p2++];
        }
        count = 0;
        for(int i=left; i<=right; i++){
            nums[i] = temp[count++];
        }
    }

    static void sort(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }
}