public class CyclicRotation {
    
    static int[] cyclicRotation(int n, int[] arr, int k) {
        int[] newArr = new int[n];
        for(int i=0; i<n; i++){
            int val = (i+k)%n;
            newArr[(i+k)%n] = arr[i];
        }
        return newArr;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};
        int[] newArr = cyclicRotation(5,arr,2);
        for(int i: newArr){
            System.out.println(i + " ");
        }
    }
}
