class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int x=0,y=0,val=0;
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                y = stack.pop();
                x = stack.pop();
                if(token.equals("+")){
                    val = x + y;
                }
                else if(token.equals("-")){
                    val = x - y;
                }
                else if(token.equals("*")){
                    val = x * y;
                }
                else if(token.equals("/")){
                    val = x / y;
                }
                stack.push(val);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}