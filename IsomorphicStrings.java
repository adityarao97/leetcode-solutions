class IsomorphicStrings {
    static boolean isIsomorphic(String s, String t) {
        for(int i=0;i<s.length()-1;i++){
            char ch = s.charAt(i);
            char ch2 = t.charAt(i);
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(j)==ch){
                    if(t.charAt(j)!=ch2){
                        return false;
                    }
                }
                if(t.charAt(j)==ch2){
                    if(s.charAt(j)!=ch){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
    }
}