public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]==target){
                return i;
            }
            else if(target<nums[i]){
                return i;
            }
            i++;
        }
        return i;
    }    
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        System.out.println(searchInsert(nums, 7));
    }
}
