class Solution {
    public int[] replaceElements(int[] arr) {
        int max = 0;
        for(int i=0;i<arr.length-1;i++){
            max = arr[i+1];
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>max){
                    max=arr[j];
                }
            }
            arr[i]=max;
        }
        arr[arr.length-1]=-1;
        return arr;
    }
}
