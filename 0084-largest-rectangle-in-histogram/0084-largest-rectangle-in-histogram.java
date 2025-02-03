class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length, index = 0, currentH = 0, prevH = 0, maxArea = 0;
        Stack<Integer[]> stack = new Stack<>(); // contains index from which area can of a rectangle can be calculated and height, area = (currentIndex - index)*height
        Integer[] top = new Integer[2];
        for(int i=0; i<len; i++){
            index = i;
            currentH = heights[i];
            while(!stack.isEmpty() && stack.peek()[1]>heights[i]){
                top = stack.pop();
                index = top[0];
                prevH = top[1];
                maxArea = Math.max(maxArea, (i-index) * prevH);
            }
            stack.push(new Integer[]{index, currentH});
        }
        while(!stack.isEmpty()){
            top = stack.pop();
            index = top[0];
            prevH = top[1];
            maxArea = Math.max(maxArea, (len-index) * prevH);
        }
        return maxArea;
    }
}