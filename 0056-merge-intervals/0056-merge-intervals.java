class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the intervals array by 1st element of each inner array 
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        //merge intervals if there's an overlap
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] prev = result.get(result.size()-1);
            int[] cur = intervals[i];
            if(prev[1] >= cur[0]){
                prev[1] = Math.max(prev[1], cur[1]);
            }else{
                result.add(cur);
            }
        }
        int[][] merged = new int[result.size()][2];
        result.toArray(merged);
        return merged;
    }
}