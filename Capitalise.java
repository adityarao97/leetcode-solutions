public class Capitalise {
    static String capitalise(String str) {
        char[] charArr = str.toCharArray();
        char ch = str.charAt(0); 
            if(ch>'a' && ch<'z'){
                charArr[0] =(char)(charArr[0]-32);         
            }
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1)==' ' || str.charAt(i-1)=='.'){
                ch = str.charAt(i);             
                if(ch>'a' && ch<'z'){
                charArr[i] =(char)(charArr[i]-32);         
                }
            }            
        }
        return new String(charArr);
    }
    
    public static void main(String[] args) {
        System.out.println(capitalise("the quick brown Fox Jumps over the lazY Fox"));
    }
}
