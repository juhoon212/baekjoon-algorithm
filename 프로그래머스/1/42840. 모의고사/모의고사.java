import java.util.*;

class Solution {
   public int[] solution(int[] answer) {

        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Integer> score = new ArrayList<>();
        score.add(0, 0);
        score.add(1, 0);
        score.add(2, 0);

        System.out.println("size = " + score.size());
        // 규칙
        // 답이 {1,2,3,4,5} 라고 가정
        for (int i = 0; i < answer.length; ++i) {
            if (one[i % one.length] == answer[i]) {
                score.set(0, score.get(0) + 1);
                System.out.println("one = " + score.get(0));
                System.out.println("size = " + score.size());
            }

            if (two[i % two.length] == answer[i]) {
                score.set(1, score.get(1) + 1);
                System.out.println("two = " + score.get(1));
                System.out.println("size = " + score.size());
            }

            if (three[i % three.length] == answer[i]) {
                score.set(2, score.get(2) + 1);
                System.out.println("three = " + score.get(2));
                System.out.println("size = " + score.size());
            }
        }

        for (int i = 0; i < score.size(); ++i) {
            System.out.println(score.get(i));
        }
        System.out.println("===============");

        int max;
        max = Math.max(Math.max(score.get(0), score.get(1)), score.get(2));

        // 가장 많은 문제를 맞추는 사람을 배열에 담아서 return
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            if (max == score.get(i)) {
                result.add(i + 1);
            }
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}