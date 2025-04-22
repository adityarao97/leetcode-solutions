class Solution {

    List<List<Integer>> result;

    public void backtrack(int[] candidates, int target, List<Integer> currentList, int index){
        if(target == 0){
            result.add(new ArrayList(currentList));
            return;
        }
        if(target < 0 || index >= candidates.length) return;
        currentList.add(candidates[index]);
        backtrack(candidates, target - candidates[index], currentList, index);
        currentList.remove(currentList.size()-1);
        backtrack(candidates, target, currentList, index + 1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        backtrack(candidates, target, currentList, 0);
        return result;
    }
}