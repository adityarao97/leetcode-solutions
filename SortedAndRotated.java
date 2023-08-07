import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SortedAndRotated {
    public static boolean check(int[] nums) {
        int counter=0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                list.add(nums[i]);
                for(int j=i+1;j<nums.length;j++){
                    list.add(counter++,nums[j]);
                }
                break;
            }
            else{
                list.add(nums[i]);
            }
        }
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
ArrayList<Integer> data = new ArrayList<Integer>();

data.add(1);

data.add(2);

data.add(4);

data.add(7);

data.add(3);

data.add(2);


int length = data.size();

data.forEach(number -> System.out.println(number));
    }

}
