import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IntersectionOfTwoArrays {
    static List<Integer> intersectionOfTwoArraysBasic(List<Integer>a, List<Integer>b){
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
        for(int x: a){
            if(mapA.containsKey(x)){
                mapA.put(x, mapA.get(x)+1);
            }
            else{
                mapA.put(x, 1);
            }
        }
        for(int y: b){
            if(mapB.containsKey(y)){
                mapB.put(y, mapB.get(y)+1);
            }
            else{
                mapB.put(y, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : mapA.entrySet()){
            if(mapB.containsKey(entry.getKey())){
                int commonKey = entry.getKey();
                int commonVal = (entry.getValue()>mapB.get(commonKey)) ? mapB.get(commonKey) : entry.getValue();
                while(commonVal>0){
                    resultList.add(commonKey);
                    commonVal--;
                }
            }
        }
        Collections.sort(resultList);
        return resultList;
    }
    

    public static void main(String args[]) throws IOException{
        List<Integer> a = new ArrayList<>(Arrays.asList(1,2,2,1));
        List<Integer> b = new ArrayList<>(Arrays.asList(2,2));
        List<Integer> resultList = intersectionOfTwoArraysBasic(a, b);
        for(int x: resultList){
            System.out.println(x);
        }
    }
}
