class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int row = 0; row < matrix.length; row++){
            if(target >= matrix[row][0] && target <= matrix[row][matrix[row].length-1]){
                return binarySearch(matrix[row], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(target == arr[mid]){
                return true;
            }
            else if(target > arr[mid]){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}