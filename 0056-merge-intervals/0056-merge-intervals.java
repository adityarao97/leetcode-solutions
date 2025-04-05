class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0]!=b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        list.add(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            int[] last = list.get(list.size()-1);
            int[] curr = intervals[i];
            //completely disjoint case
            if(last[1] < curr[0]){
                list.add(curr);
            }
            //partially or complete joint case
            else{
                list.set(list.size()-1, new int[]{Math.min(last[0], curr[0]), Math.max(last[1], curr[1])});
            }
        }
        int[][] result = new int[list.size()][2];
        int count = 0;
        for(int[] item: list){
            result[count++] = item;
        }
        return result;
    }
}