class Solution {

    List<List<Integer>> result;

    public void dfs(int index, List<Integer> currentList, int target, int[] candidates){
        if(target == 0){
            result.add(new ArrayList(currentList));
            return;
        }
        if(target < 0 || index >= candidates.length) return;
        currentList.add(candidates[index]);
        dfs(index, currentList, target-candidates[index], candidates);
        currentList.remove(currentList.size()-1);
        dfs(index + 1, currentList, target, candidates);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        dfs(0, currentList, target, candidates);
        return result;
    }
}