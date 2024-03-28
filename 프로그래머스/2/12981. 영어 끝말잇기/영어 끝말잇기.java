
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
       앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
       이전에 등장했던 단어는 사용할 수 없습니다.
       한 글자인 단어는 인정되지 않습니다.
       result[0] = 탈락한 사람의 번호
       result[1] = 자신의 몇번쨰 차례에 탈락하는지
 */
public class Solution {

    // TODO 다시 풀어보기

    public int[] solution(int n, String[] words) {

        int[] answer = {0,0};

        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 0);

        for (int i = 1; i < words.length; i++) {
            map.put(words[i], 0);
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0) ||
                map.size() < i + 1
            ) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }

    
}
