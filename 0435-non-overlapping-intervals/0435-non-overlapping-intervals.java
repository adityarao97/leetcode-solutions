class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        int prevEnd = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            int curr = intervals[i][0];
            int end = intervals[i][1];
            //check if there's no overlap
            if(prevEnd<=curr){
                prevEnd = end;
            }
            //if there's an overlap we take the minimum end value to be the prevEnd
            else{
                res++;
                prevEnd = Math.min(prevEnd, end);
            }
        }
        return res;
    }
}