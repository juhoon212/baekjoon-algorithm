class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(potions);

        for (int spell : spells) {
            int left = 0, right = potions.length-1;
            int idx = potions.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                
                if ((long) spell * potions[mid] >= success) {
                    right = mid-1;
                    idx = mid;
                } else {
                    left = mid+1;
                }
            }
            list.add(potions.length - idx);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}