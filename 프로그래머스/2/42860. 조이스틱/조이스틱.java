class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {

            int spellToInt = name.charAt(i) - 'A';
            int spellToIntRev = 'Z' - name.charAt(i) + 1;

            final int minResult = Math.min(spellToIntRev, spellToInt);
            answer += minResult;

            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 순서대로 가기 vs 뒤로 돌아가기
            move = Math.min(move, (i * 2) + name.length() - next);
            move = Math.min(move, (name.length() - next) * 2 + i);
        }

        answer += move;



        return answer;
    }
}