public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        if((nums.length==0) || (nums.length==1 && nums[0]==val)){
            return 0;
        }
        if(nums.length==1 && nums[0]!=val){
            return 1;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]==val && i!=nums.length){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j]!=val){
                        nums[i]=nums[j];
                        nums[j]=val;
                        k++;
                        break;
                    }
                }
            }
            else{
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }
}
