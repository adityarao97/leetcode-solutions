class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<String>();
        //loop across each characters in the string
        StringBuilder word = new StringBuilder();
        //if the character is a space and word is empty ignore
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
        //if the character is a space and word is not empty push it to stack
            if(ch == ' '){
                if (word.length()>0){
                    stack.push(word.toString());
                    word = new StringBuilder();
                }
            }
            //if the character is not a space then 
            else{
                word.append(ch);
            }
        }
        if(word.length>0){
            stack.push(word.toString());
        }
        //pop the stack until it's empty and append it to a string
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop() + " ");
        }
        return res.toString().trim(); 
    }
}