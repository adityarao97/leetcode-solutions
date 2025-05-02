class MedianFinder {

    Queue<Integer> smallHeap;
    Queue<Integer> largeHeap;

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        largeHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        if(smallHeap.size()-largeHeap.size()>1 || !largeHeap.isEmpty() && largeHeap.peek()<smallHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size()-smallHeap.size()>1){
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        if((smallHeap.size() + largeHeap.size())%2==0){
            return (smallHeap.peek() + largeHeap.peek())/2.0;
        }
        else{
            if(smallHeap.size()>largeHeap.size()){
                return (double)smallHeap.peek();
            }
            else{
                return (double)largeHeap.peek();
            }
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */