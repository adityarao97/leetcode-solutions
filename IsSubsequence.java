public class IsSubsequence {
    static char returnCharPosition(String str, char ch){
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==ch){
                return ch;
            }
        }
       return '\0';
    }

    static public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        if(s.length()!=0 && t.length()==0){
            return false;
        }
        char pos = returnCharPosition(t,s.charAt(0));
        if(pos=='\0'){
            return false;
        }
        for(int i=1; i<s.length(); i++){
            char newPos = returnCharPosition(t,s.charAt(i));
            if(newPos<pos || newPos==-1){
                return false;
            }
            else if(newPos>pos){
                pos = newPos;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa","bbaaaa"));
    }
}
