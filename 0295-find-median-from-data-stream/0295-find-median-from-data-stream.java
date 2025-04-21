class MedianFinder {

    private Queue<Integer> smallHeap;
    private Queue<Integer> largeHeap;

    public MedianFinder() {
        //smallHeap is max heap
        smallHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        //largeHeap is min heap
        largeHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    }
    
    public void addNum(int num) {
        //initially add num to small heap
        smallHeap.add(num);
        //if the size difference is more than 1 we adjust
        if(smallHeap.size() - largeHeap.size() > 1 || !largeHeap.isEmpty() && smallHeap.peek()>largeHeap.peek()){
            largeHeap.add(smallHeap.poll());
        }
        if(largeHeap.size() - smallHeap.size() > 1){
            smallHeap.add(largeHeap.poll());
        }
    }
    
    public double findMedian() {
        //if both heaps have same size median will be average of two values from each heap
        if(smallHeap.size() == largeHeap.size()){
            return (smallHeap.peek() + largeHeap.peek())/2.0;
        }
        if(smallHeap.size() > largeHeap.size()){
            return smallHeap.peek();
        }
        return largeHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */