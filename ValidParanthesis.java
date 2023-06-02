public class ValidParanthesis {
public static char[] pushToStack(char[] arr,char c){
        char[] temp = new char[arr.length+1];
        int i=0;
        for(i=0;i<temp.length;i++){
            temp[i]=arr[i];
        }
        temp[i]=c;
        return temp;
    }

public static char[] popFromStack(char[] arr){
    char[] temp = new char[arr.length-1];
    for(int i=0;i<arr.length-1;i++){
        temp[i]=arr[i];
    }
    return temp;
}

public static void isValid(String s) {
    char[] arr = new char[0];
    for(int i=0; i<s.length(); i++){
        char ch = s.charAt(i);
        if(ch=='(' || ch=='{' || ch=='['){
            arr = pushToStack(arr,ch);
        }
        else if(ch==')' || ch=='}' || ch==']'){
            arr = popFromStack(arr);
        }
    }
    if(arr[0]=='\0'){
        System.out.println("True");
    }
    else{
        System.out.println("False");
    }
}

public static void main(String[] args) {
    String s = "()";
    isValid(s);
}
    
}
