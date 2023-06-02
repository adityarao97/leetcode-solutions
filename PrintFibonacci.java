import java.util.Scanner;

public class PrintFibonacci {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            int result = largestFibonacciNumber(n);
            System.out.println(result);
        }
        sc.close();
    }

    static int largestFibonacciNumber(int n){
        int n1=0;
        int n2=1;
        int n3=0;
        while(n3<n){
            if(n2>n){
                break;
            }
            n3=n1+n2;
            n1=n2;
            n2=n3;
        }
        return n1;
    }
}
