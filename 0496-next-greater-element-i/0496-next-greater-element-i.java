class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int count = 0;
        for(int i=0;i<nums1.length;i++){
            int index = getIndex(nums2, nums1[i]);
            if(index==nums2.length-1){
                res[count++] = -1;
                continue;
            }
            boolean flag = false;
            for(int j=index+1;j<nums2.length;j++){
                if(nums2[j]>nums1[i]){
                    res[count++] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                res[count++] = -1;
            }
        }
        return res;
    }

    public int getIndex(int[] arr, int val){
        for(int i=0;i<arr.length;i++){
            if(val == arr[i]){
                return i;
            }
        }
        return -1;
    }
}