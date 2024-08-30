class Solution {
    public int maxDepth(String s) {
        int max = Integer.MIN_VALUE;
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int stackCounter = 0;
        for(char ch: arr){
            if(ch=='('){
                stack.push(ch);
                stackCounter++;
            }
            else if(ch==')'){
                max = Math.max(max, stackCounter);
                stackCounter--;
                stack.pop();
            }
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }
}