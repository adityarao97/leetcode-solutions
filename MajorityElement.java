public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        if(nums.length==1){
            return nums[0];
        }
        int halfValue = nums.length/2;
        for(int i = 0; i<nums.length; i++){
            count=1;
            for(int j = 0; j<nums.length; j++){
                if(i!=j && nums[i]==nums[j]){
                    count++;
                    if(count>halfValue){
                        return nums[i];
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3,2};
        System.out.println(majorityElement(nums));
    }
}
