class Solution {

    public void swap(char[] s, int l, int r){
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }

    public void recursiveReverse(char[] s, int l, int r){
        if(l == r || l>r){
            return;
        }
        swap(s, l, r);
        recursiveReverse(s, l+1, r-1);
    }

    public void reverseString(char[] s) {
        recursiveReverse(s, 0, s.length-1);
    }
}