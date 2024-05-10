class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>(1);
        firstList.add(1);
        result.add(firstList);
        for(int i=1;i<numRows;i++){
            List<Integer> list = new ArrayList<>(i+1);
            List<Integer> prevList = result.get(i-1);
            list.add(1);
            list.add(list.size()-1,1);
            if(prevList.size()>=2){
                for(int j=1;j<=prevList.size()-1;j++){
                    list.add(j,prevList.get(j-1)+prevList.get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}