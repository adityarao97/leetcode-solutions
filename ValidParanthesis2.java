import java.util.Stack;

public class ValidParanthesis2 {

    public static boolean isOppositeBracket(char poppedElem, char ch){
        if(poppedElem == '{' && ch =='}'){
            return true;
        }    
        else if(poppedElem == '[' && ch ==']'){
            return true;
        }
        else if(poppedElem == '(' && ch == ')'){
            return true;
        }
        return false;
    }

    public static String isValid(String s) {
        Stack<Character> stack = new Stack<>();
        //iterate through the character array
        // if character is an opening bracket push to stack
        // if character is a closing bracket pop from stack and compare with popped character
        //      if not equal return false
        // if stack becomes empty return true 
        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else{
                char poppedElem = stack.pop();
                if(!isOppositeBracket(poppedElem,ch)){
                    return "false";
                }
            }
        }
        if(stack.isEmpty()){
            return "true";
        }
        return "false";
    }

    public static void main(String[] args) {
        String s = ")}(){";
        System.out.println(isValid(s));
    }
    
}
