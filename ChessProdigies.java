import java.util.*;

public class ChessProdigies {
    static List chessProdigy(int[] rating) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int sum = 0;
        for(int i=rating.length-1;i>=0;i--){ 
            if(rating[i]>sum){
                list.add(rating[i]);
            }
            sum+=rating[i];
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String args[]) {
        int[] arr = new int[] { 16, 27, 1, 3, 8, 3 };
        List resultList = new ArrayList<String>();
        resultList = chessProdigy(arr); 
        assert Arrays.asList(27, 8, 3).equals(chessProdigy(new int[] { 16, 27, 1, 3, 8, 3 })) : "Expect {27, 8, 3} for array={16, 27, 1, 3, 8, 3}";
        System.out.println("All test cases in main function passed");

    }
}
