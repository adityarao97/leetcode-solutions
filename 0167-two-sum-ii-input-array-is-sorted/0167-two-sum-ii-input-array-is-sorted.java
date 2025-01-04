class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1=0, p2=numbers.length-1, sum=0;
        int[] res = new int[2];
        while(p1<p2){
            sum = numbers[p1] + numbers[p2];
            if(sum==target){
                res[0] = p1+1;
                res[1] = p2+1;
                return res;
            }
            else if(sum<target){
                p1++;
            }
            else{
                p2--;
            }
        }
        return res;
    }
}