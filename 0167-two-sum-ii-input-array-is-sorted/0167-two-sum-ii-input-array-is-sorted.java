class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int p1 = 0, p2 = numbers.length-1, sum = 0;
        while(p1<p2){
            sum = numbers[p1] + numbers[p2]; 
            if(sum == target){
                res[0] = p1+1;
                res[1] = p2+1;
                return res;
            }
            else if(sum>target){
                p2--;
            }
            else{
                p1++;
            }
        }
        return res;
    }
}