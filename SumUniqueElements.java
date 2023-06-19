import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SumUniqueElements {
    public static int sumOfUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int x: nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }
            else{
                map.put(x,1);
            }
        }
        Iterator it = map.entrySet().iterator();
        int sum = 0;
        while(it.hasNext()){
            Map.Entry mapElement = (Map.Entry)it.next();
            if((int)mapElement.getValue()==1){
                sum+=(int)mapElement.getKey();
            }
        }
        return sum; 
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2};
        System.out.println(sumOfUnique(nums) + "");
    }
}
