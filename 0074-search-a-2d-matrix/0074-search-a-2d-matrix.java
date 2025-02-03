class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row = 0; row<matrix.length; row++){
            int[] cRow = matrix[row];
            if(target<=cRow[cRow.length-1]){
                int left = 0, right = cRow.length-1;
                while(left<=right){
                    int mid = (left + right)/2;
                    if(target == cRow[mid]){
                        return true;
                    }
                    else if(target < cRow[mid]){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}