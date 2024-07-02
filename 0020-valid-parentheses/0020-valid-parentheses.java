class Solution {
    public boolean isValid(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char ch: charArr){
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else {
                if(stack.size()==0){
                    return false;
                }
                char popped = stack.pop();
                if((ch == ')' && popped != '(') || (ch == ']' && popped != '[') || (ch == '}' && popped != '{')){
                    return false;
                }
            }
        }
        if(stack.size()==0){
            return true;
        }
        return false;
    }
}