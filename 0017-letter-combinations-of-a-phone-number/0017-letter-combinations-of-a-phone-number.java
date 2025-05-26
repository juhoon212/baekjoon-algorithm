class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answers = new ArrayList<>();
        if (digits.length() == 0) {
            return answers;
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

        
        backTrack(digits, 0, new StringBuilder(), map, answers);
        return answers;
    }

    void backTrack(String digits, int index, StringBuilder sb, Map<Character, String> map, List<String> answers) {
        if (index == digits.length()) {
            answers.add(sb.toString());
            return;
        }

        String letter = map.get(digits.charAt(index)); // abc

        for (Character digit : letter.toCharArray()) {
            sb.append(digit);
            backTrack(digits, index+1, sb, map, answers);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}