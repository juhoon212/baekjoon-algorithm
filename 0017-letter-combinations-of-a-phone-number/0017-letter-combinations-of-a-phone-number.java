class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        List<String> answers = new ArrayList<>();

        if (digits == null || digits.equals("")) {
            return answers;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backTrack(digits, 0, map, answers, new StringBuilder());
        return answers;
    }

    void backTrack(String digits, int idx, Map<Character, String> map, List<String> answers, StringBuilder sb) {
        
        // 탈출 조건
        if (idx == digits.length()) {
            answers.add(sb.toString());
            return;
        }

        String letters = map.get(digits.charAt(idx));
        for (Character digit : letters.toCharArray()) {
            sb.append(digit);
            backTrack(digits, idx+1, map, answers, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}