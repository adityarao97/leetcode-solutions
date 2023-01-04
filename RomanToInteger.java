public class RomanToInteger {
    public static int romanToInt(String s) {
    int number = 0;
        int len = s.length();
        for(int i=0; i<len; i++){
            if(s.charAt(i)=='I'){
                if(i<len-1){
                    if(s.charAt(i+1)=='V'){
                        number = number + 4;
                        i++;
                        continue;
                    }
                    if(s.charAt(i+1)=='X'){
                        number = number + 9;
                        i++;
                        continue;
                    }
                }
                number = number +1;
            }
            if(s.charAt(i)=='V'){
                number = number +5;
            }
            if(s.charAt(i)=='X'){
                if(i<len-1){
                    if(s.charAt(i+1)=='L'){
                        number = number + 40;
                        i++;
                        continue;
                    }
                    if(s.charAt(i+1)=='C'){
                        number = number + 90;
                        i++;
                        continue;
                    }
                }
                number = number +10;
            }
            if(s.charAt(i)=='L'){
                number = number +50;
            }
            if(s.charAt(i)=='C'){
                if(i<len-1){
                    if(s.charAt(i+1)=='D'){
                        number = number + 400;
                        i++;
                        continue;
                    }
                    if(s.charAt(i+1)=='M'){
                        number = number + 900;
                        i++;
                        continue;
                    }
                }
                number = number +100;
            }
            if(s.charAt(i)=='D'){
                number = number + 500;
            }
            if(s.charAt(i)=='M'){
                number = number + 1000;
            }
        }
        return number;
    }
    
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
