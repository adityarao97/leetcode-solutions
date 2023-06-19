public class LatestTime {
    public static String maximumTime(String time) {
        char[] timeArr = time.toCharArray();
        if(time.charAt(0)=='?'){
            if(time.charAt(1)=='3' || time.charAt(1)=='2' || time.charAt(1)=='1' || time.charAt(1)=='0'){
                timeArr[0]='2';
            }
            else if(time.charAt(1)=='?'){
                timeArr[0]='2';
                timeArr[1]='3';
            }        
            else{
                timeArr[0]='1';
            }
        }
        if(time.charAt(1)=='?'){
            if(time.charAt(0)=='2'){
                timeArr[1]='3';
            }
            else if(time.charAt(0)=='?'){
                timeArr[0]='2';
                timeArr[1]='3';
            }
            else{
                timeArr[1]='9';
            }
        }
        if(time.charAt(3)=='?'){
            if(time.charAt(4)=='?'){
                timeArr[3]='5';
                timeArr[4]='9';
            }
            else{
                timeArr[3]='5';
            }
        }
        if(time.charAt(4)=='?'){
            if(time.charAt(3)=='?'){
                timeArr[3]='5';
                timeArr[4]='9';
            }
            else{
                timeArr[4]='9';
            }
        }
        return new String(timeArr);
    }

    public static void main(String[] args) {
        System.out.println(maximumTime("2?:?0"));    
    }
}
