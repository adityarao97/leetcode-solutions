public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int endIndexOfString = 0;
        int firstIndexOfString = 0;
        for(int i=s.length()-1; i>=0; i--){
            char ch = s.charAt(i);
            if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                endIndexOfString = i;
                break;
            }
        }
        for(int i=endIndexOfString; i>=0; i--){
            char ch = s.charAt(i);
            if(!((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))){
                    firstIndexOfString = i;
                    break;    
            }
            if(((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) && i==0){
                firstIndexOfString = i-1;
                break;    
        }
        }
        return endIndexOfString-firstIndexOfString;
    }

        public static void main(String[] args) {
                System.out.println(lengthOfLastWord("Hello World"));
        }
}
