class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        int r = 0, count = 0;
        while(r < n){
            //keep removing left most element from queue until if it's less than the element being added at the right
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[r]){
                deque.removeLast();
            }
            //right most element is now the biggest so add it to the queue
            deque.addLast(r);
            //remove left if it goes out of bounds
            if(count>deque.getFirst()){
                deque.removeFirst();
            }
            //for each iteration where we encounter the end of window i.e r equals k we'd like to set output to left most value of queue
            if((r + 1) >= k){
                output[count++] = nums[deque.getFirst()];
            }
            r++;
        }
        return output;
    }
}