class Solution {

    private int recursive(int val){
        if(val == 0){
            return 0;
        }
        if(val == 1){
            return 1;
        }
        return recursive(val - 1) + recursive(val - 2);
    }

    public int fib(int n) {
        return recursive(n);
    }
}