class Solution {
    public boolean closeStrings(String word1, String word2) {
        // length compare
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        char[] charArr = word1.toCharArray();

        // a:1, b:2
        for (char word : charArr) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        char[] charArr2 = word2.toCharArray();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char word : charArr2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }

        List<Integer> mapList1 = map.values().stream().sorted().toList();
        List<Integer> mapList2 = map2.values().stream().sorted().toList();


        if (!map.keySet().equals(map2.keySet())) {
            return false; // 문자 집합이 다름
        }

        return mapList1.equals(mapList2);
    }
}