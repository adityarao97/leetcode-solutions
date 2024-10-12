class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = Arrays.stream(piles).max().getAsInt(), ans = 0;
        while(left <= right){
            int speed = (left + right)/2;
            int time = calculateTime(piles, speed);
            if(time > h){
                left = speed + 1;
            }
            else{
                ans = speed;
                right = speed - 1;
            }
        }
        return ans;
    }

    public int calculateTime(int[] bananas, int speed){
        int time = 0;
        for(int banana: bananas){
            time += Math.ceil((double)banana/speed);
        }
        return time;
    }

}