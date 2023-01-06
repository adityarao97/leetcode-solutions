//currently un-optimized for very large binary numbers which exceed the integer limit
public class AddBinary {
    private static String intToBinary(int n){
        String remainder = "";
        if(n==0){
            return "0";
        }
        while(n>0){
            remainder += n%2;
            n=n/2;
        }
        char[] temp = new char[remainder.length()];
        int count = 0;
        for(int i=remainder.length()-1; i>=0;i--){
            temp[count++] = remainder.charAt(i);  
        }
        remainder = new String(temp);
        return remainder;
    }

    private static int binaryToInt(String s){
        int number = 0;
        for(int i=0; i< s.length(); i++){
                int ch = Character.getNumericValue(s.charAt(i)); 
                number = number + (ch * (int)Math.pow(2,s.length()-1-i));   
            }
        return number;
    } 

    public static String addBinary(String a, String b) {
        int aAsInt = binaryToInt(a);
        int bAsInt = binaryToInt(b);
        int totalAsInt = aAsInt + bAsInt;
        String binaryValue = intToBinary(totalAsInt);
        return binaryValue; 
    }

    public static void main(String[] args) {
        System.out.println(addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101","110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}