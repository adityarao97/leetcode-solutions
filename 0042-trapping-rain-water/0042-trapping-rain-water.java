class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        int[] minLeftRight = new int[len];
        int max = 0, temp=0;
        maxLeft[0] = 0;
        maxRight[len-1] = 0;
        for(int i=1;i<len;i++){
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }
        for(int i=len-2;i>=0;i--){
            maxRight[i] = Math.max(maxRight[i+1],height[i+1]);
        }
        for(int i=0;i<len;i++){
            minLeftRight[i] = Math.min(maxLeft[i], maxRight[i]);
            temp = minLeftRight[i] - height[i];
            if(temp>0){
                max+=temp;
            }
        }
        return max;
    }
}