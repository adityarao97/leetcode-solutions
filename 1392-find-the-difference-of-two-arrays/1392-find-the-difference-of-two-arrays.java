class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        HashSet<Integer> set4 = new HashSet<>();
        for(int n: nums1){
            set1.add(n);
        }
        for(int n: nums2){
            set2.add(n);
        }
        for(int n: nums1){
            if(!set2.contains(n)){
                set3.add(n);
            }
        }for(int n:nums2){
            if(!set1.contains(n)){
                set4.add(n);
            }
        }
        res.add(new ArrayList<>(set3));
        res.add(new ArrayList<>(set4));
        return res;
    }
}