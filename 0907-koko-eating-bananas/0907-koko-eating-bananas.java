class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 0, right = Arrays.stream(piles).max().getAsInt();
        int ans = 0, speed = 0, time = 0;
        while(left <= right){
            speed = (left + right)/2;
            time = calculateTime(piles, speed);
            if(time<=h){
                ans = speed;
                right = speed - 1;
            }
            else{
                left = speed + 1;
            }
        }
        return ans;
    }

    private int calculateTime(int[] piles, int mid){
        int time = 0;
        for(int pile: piles){
            time+=Math.ceil((double)pile/mid);
        }
        return time;
    }
}