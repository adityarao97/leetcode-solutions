import java.util.*;

public class ForwardDiagonalMaxSum {
    static int findLastDiagonalElement(ArrayList<ArrayList<Integer>>M, int row, int col){
        if(row==M.size()-1 || col==M.get(0).size()-1){
            return 1;
        }
        int count=0,i=row,j=col;
        while(i<=M.size()-1 && j<=M.get(i).size()-1){
            count++;
            i++;
            j++;
        }
        return count;
    }

    static int largestForwardDiagonal(ArrayList<ArrayList<Integer>>M){
        int sumDiagonal = 0;
        int maxSumDiagonal = 0;
        for(int i=0;i<M.get(0).size();i++){
            int lastDiagonalValue = findLastDiagonalElement(M,0,i);
            int iNew = 0;
            sumDiagonal=0;
            for(int j=i;iNew<lastDiagonalValue;j++){
                sumDiagonal+=M.get(iNew).get(j);
                iNew++;
            }
            if(sumDiagonal>maxSumDiagonal){
                maxSumDiagonal = sumDiagonal;
            }
        }
        if(M.size()>1){
            for(int i=1;i<M.size();i++){
                int lastDiagonalValue = findLastDiagonalElement(M,i,0);
                sumDiagonal=0;
                int iNew=i;
                for(int j=0;j<lastDiagonalValue;j++){
                    sumDiagonal+=M.get(iNew).get(j);
                    iNew++;
                }
                if(sumDiagonal>maxSumDiagonal){
                    maxSumDiagonal = sumDiagonal;
                }
            }
        }
        return maxSumDiagonal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> M = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer>temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(sc.nextInt());
            }
            M.add(temp);
        }
        int result = largestForwardDiagonal(M);
        System.out.println(result);
        sc.close();    
    }
    
}
