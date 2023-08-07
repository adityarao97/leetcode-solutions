public class Palindrome {
    public static boolean isPalindrome(int x) {
        if((x%10==0 &&x!=0) || x<0){
            return false;
        }
        int reverseNum = 0;
        while(x>reverseNum){
            reverseNum = reverseNum*10 + x%10;
            x=x/10;
        }
        return x==reverseNum || x==(reverseNum/10);
        }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
