class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k==1) return 0;
        //the first and last index will always be same irrespective of input so on maxScore - minScore they will always be 0 hence we can ignore them
        int n = weights.length;
        List<Integer> pairSums = new ArrayList<>();
        //we store pairSums which is a sum of elements on border indexes on all possible splits
        for(int i=0; i<n-1; i++){
            pairSums.add(weights[i] + weights[i+1]);
        }
        //sort them 
        Collections.sort(pairSums);
        n = pairSums.size();
        long minScore = 0, maxScore = 0;
        //min score will be on first k splits and max score will be on last k splits
        for(int i=0; i<k-1; i++){
            minScore += pairSums.get(i);
            maxScore += pairSums.get(n - 1 - i);
        }
        return maxScore - minScore;
    }
}