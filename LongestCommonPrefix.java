public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String longestPrefix = "";
        if(strs.length==1){
            return strs[0];
        }
        for(int j=0; j<strs[0].length(); j++){
            longestPrefix += strs[0].charAt(j);
            for(int i=1; i<strs.length; i++){
                if(strs[i].length()<j+1){
                    if(j==0){
                        return "";
                    }
                    return longestPrefix.substring(0,longestPrefix.length()-1);
                }
                else{
                if(!(longestPrefix.charAt(j)==(strs[i].charAt(j)))){
                    if(j==0){
                        return "";
                    }
                    return longestPrefix.substring(0,longestPrefix.length()-1);                    
                    }
                }
            }
        }
        return longestPrefix;
    }
    
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
