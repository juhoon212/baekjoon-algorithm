class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        // 가운데를 기준으로 기준 값 보다 클때
        Arrays.sort(potions);

        List<Integer> list = new ArrayList<>();

        for (int spell : spells) {
            int left = 0, right = potions.length-1;
            int idx = potions.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((long)spell * potions[mid] >= success) {
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