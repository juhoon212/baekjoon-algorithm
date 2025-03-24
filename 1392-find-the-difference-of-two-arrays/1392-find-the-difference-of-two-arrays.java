class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i=0; i<nums1.length; ++i) {
            set.add(nums1[i]);
        }

        for (int i=0; i<nums2.length; ++i) {
            set2.add(nums2[i]);
        }

        List<Integer> innerList1 = new ArrayList<>();
        List<Integer> innerList2 = new ArrayList<>();

        for (int num : set) {
            if (!set2.contains(num)) {
                innerList1.add(num);
            }
        }

        for (int num : set2) {
            if (!set.contains(num)) {
                innerList2.add(num);
            }
        }
        

        return Arrays.asList(innerList1, innerList2);
    }
}