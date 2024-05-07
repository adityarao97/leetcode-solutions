class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals("")){
            return true;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        for(char ch: arr1){
            queue.add(ch);
        }
        for(char ch: arr2){
            if(ch==queue.peek()){
                queue.remove();
                if(queue.isEmpty()){
                    return true;
                }
            }
        }
        return false;
    }
}