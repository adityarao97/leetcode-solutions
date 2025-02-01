class Solution {

    public void backTracking(int openCount, int closeCount, StringBuilder stack, List<String> result, int n){
        if(openCount==closeCount && openCount==n){
            result.add(stack.toString());
            return;
        }

        if(openCount<n){
            stack.append('(');
            backTracking(openCount+1, closeCount, stack, result, n);
            stack.deleteCharAt(stack.length()-1);
        }

        if(closeCount<openCount){
            stack.append(')');
            backTracking(openCount, closeCount+1, stack, result, n);
            stack.deleteCharAt(stack.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTracking(0, 0, new StringBuilder(), result, n);
        return result;
    }
}