class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int n: nums){
            set.add(n);
        }
        Iterator<Integer> iterator = set.iterator();
        int element = iterator.next();
        int counter = 1;
        int maxCounter = 0;
        while(iterator.hasNext()){
            int nextElement = iterator.next();
            if(nextElement == (element + 1)){
                counter++;
            }
            else{
                if(counter>maxCounter){
                    maxCounter = counter;
                }
                counter = 1;
            }
            element = nextElement;
        }
        return Math.max(counter,maxCounter);
    }
}