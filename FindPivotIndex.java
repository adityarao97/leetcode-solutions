public class FindPivotIndex {
        static int findSum(int[] nums,int l, int r){
            int sum = 0;
            for(int i=l; i<=r; i++){
                sum += nums[i];
            }
            return sum;
        }
        static int pivotIndex(int[] nums) {
            int sumLeft = 0;
            int sumRight = findSum(nums, 1, nums.length-1);
            int pivotIndex = 0;
            if(sumRight==0){
                return 0;
            }
            while(sumLeft!=sumRight){
                    pivotIndex++;
                    if(pivotIndex==nums.length-1){
                        sumLeft = findSum(nums, 0, pivotIndex-1);
                        if(sumLeft==0){
                            return pivotIndex;
                        }
                        return -1;
                    }
                    sumLeft = findSum(nums, 0, pivotIndex-1);
                    sumRight = findSum(nums, pivotIndex+1, nums.length-1);
                }
            return pivotIndex;
        }
    public static void main(String[] args) {
           int nums[] = new int[]{-1,-1,-1,1,1,1};
           int pivotIndex = pivotIndex(nums);
           System.out.println(pivotIndex);
    }    
}
