class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }


        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(digits, 0, new StringBuilder(), res, map);

        return res;
    }

    void backTrack(
        String digits, 
        int idx, 
        StringBuilder comb, 
        List<String> res,
        Map<Character, String> letters
    ) {

        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }

        String matchLetter = letters.get(digits.charAt(idx));
        for (char letter : matchLetter.toCharArray()) {
            comb.append(letter);
            backTrack(digits, idx+1, comb, res, letters);
            comb.deleteCharAt(comb.length()-1);
        }
    }
}