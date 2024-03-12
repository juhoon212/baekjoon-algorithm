class Solution {
     public String solution(String s) {

        String answer = "";
        String[] split = s.toLowerCase().split("");
        boolean isFirst = true;

        for (String word : split) {
            answer += isFirst ? word.toUpperCase() : word;
            isFirst = word.equals(" ")? true : false;
        }

        return answer;
    }
}