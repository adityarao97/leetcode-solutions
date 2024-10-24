class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for(char ch : charArr){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                if(stack.size()<=0){
                    return false;
                }
                char temp = stack.pop();
                if((temp == '(' && ch != ')') || (temp == '{' && ch != '}') || (temp == '[' && ch != ']')){
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