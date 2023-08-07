import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
        public static List<String> fizzBuzz(int n) {
            List<String> resultList = new ArrayList<String>();
            for(int i=1;i<=n;i++){
                if(i%3==0 && i%5==0){
                    resultList.add("FizzBuzz");
                }
                else if(i%3==0 && i%5!=0){
                    resultList.add("Fizz");
                }
                else if(i%5==0 && i%3!=0){
                    resultList.add("Buzz");
                }
                else{
                    resultList.add("" + i);
                }
            }
            return resultList;
        }
        public static void main(String[] args) {
            System.out.println(fizzBuzz(30) + "");
        }
    }
