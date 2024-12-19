class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int y = stack.pop();
                int x = stack.pop();
                int res = 0;
                if(token.equals("+")){
                    res = x+y;
                }
                if(token.equals("-")){
                    res = x-y;
                }
                if(token.equals("*")){
                    res = x*y;
                }
                if(token.equals("/")){
                    res = x/y;
                }
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}