class Solution {
    public int arraySign(int[] nums) {
        int mult = 1;
        for(int n: nums){
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                mult *= -1;
            } else {
                mult *= 1;
            }
        }
        if(mult<0){
            return -1;
        }
        return 1;
    }
}