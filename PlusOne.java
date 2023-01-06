import java.util.Arrays;

public class PlusOne {
    private static int[] plusOne(int[] digits){
        int[] oldArr = Arrays.copyOf(digits, digits.length);
        int[] newArr = increaseAllByOne(digits,digits.length-1);
        int[] revisedArray = null;
        if(newArr[0]!=oldArr[0] && newArr[0]==0){
            revisedArray = new int[digits.length+1];
            revisedArray[0] = 1; 
            for(int i=1;i<revisedArray.length-1;i++){
                revisedArray[i] = newArr[i-1];
            }
            return revisedArray;
        }
        return newArr;
    }

    private static int[] increaseAllByOne(int[] nums,int i){
        if(i==-1){
            return nums;
        }
        if(nums[i]!=9){
            nums[i] = nums[i] + 1;
        }
        else{
            nums[i] = 0;
            increaseAllByOne(nums, i-1);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9,9,9,9,9};
        plusOne(digits);
    }    
}