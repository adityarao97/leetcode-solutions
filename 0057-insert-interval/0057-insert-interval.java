class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length, i = 0;
        //Loop until the end element of interval is less than the first element of newInterval
        while(i<n && intervals[i][1] < newInterval[0]){
            //keep adding the intervals to list
            list.add(intervals[i]);
            i++;
        }
        //now we can merge the newInterval to intervals
        //check until when is the end of newInterval greater than the start of interval item, update newInterval based on the min and max value
        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        //add it to list
        list.add(newInterval);
        //add remaining intervals
        while(i<n){
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}