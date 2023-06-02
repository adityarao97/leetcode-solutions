
public class MagicSquare {
    static boolean isMagicSquare(int[][] arr) {
        boolean flag=false;
        int colSum = 0;
        int rowSum = 0;
        int diaSum1 = 0;
        int diaSum2 = 0;
        int sumVal = 0;
        int arrLength = arr[0].length;
        for(int i=0;i<arrLength;i++){
            sumVal+=arr[0][i];
            diaSum1+=arr[i][i];
            diaSum2+=arr[i][(arrLength-1)-i];
        }
        if(diaSum1!=sumVal || diaSum2!=sumVal){
            return false;
        }
        else{
            flag=true;
        }
        for(int i=0;i<arrLength;i++){
            for(int j=0;j<arrLength;j++){
                colSum+=arr[i][j];
                rowSum+=arr[j][i];
            }
            if(colSum!=sumVal && rowSum!=sumVal){
                    return false;
                }
            else{
                    flag=true;
                    colSum=0;
                    rowSum=0;
                }
        }
        return flag ? true : false;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{4,9,2}, {3,5,7}, {8,1,6}};
        assert isMagicSquare(arr1) == true : "Expect true for arr = {{4,9,2}, {3,5,7}, {8,1,6}}";

        int[][] arr2 = {{4,9,2}, {3,5,9}, {8,1,6}};
        assert isMagicSquare(arr2) == false : "Expect false for arr = {{4,9,2}, {3,5,9}, {8,1,6}}";
        System.out.println("All test cases in main function passed");    
    }
    
}
