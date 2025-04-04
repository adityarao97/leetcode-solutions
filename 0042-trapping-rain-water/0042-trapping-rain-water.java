class Solution {
    public int trap(int[] height) {
        int res = 0;
        int totalBuildings = height.length;
        //create a prefix max array which for a given index will indicate max height on the left
        int[] maxLeft = new int[totalBuildings];
        maxLeft[0] = height[0];
        for(int i=1; i<totalBuildings; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }
        //create a suffix max array which for a given index will indicate max height on the right
        int[] maxRight = new int[totalBuildings];
        maxRight[totalBuildings-1] = height[totalBuildings-1];
        for(int i=totalBuildings-2; i>=0; i--){
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }
        //At each index the rain water trapped will be min of (maxLeft and maxRight) - height
        for(int i=0; i<totalBuildings; i++){
            res+=Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return res;
    }
}