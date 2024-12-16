import java.util.*;

class Solution {
public int[] solution(String today, String[] terms, String[] privacies) {

        Map<String, Integer> termsMap = new HashMap<>();
        int todayDate = getDate(today);
        List<Integer> answer = new ArrayList<>();

        for (String term : terms) {

            String[] split = term.split(" ");
            termsMap.put(split[0], Integer.parseInt(split[1]));
        }

            for (int i = 0; i < privacies.length; i++) {
                String[] prvSplit = privacies[i].split(" ");

                if(getDate(prvSplit[0]) + (termsMap.get(prvSplit[1]) * 28) <= todayDate) {
                    answer.add(i+1);
                }
            }
        return answer.stream().mapToInt(integer -> integer).toArray();
    }

    private int getDate(String today) {
        String[] date = today.split("\\.");

        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return (month * 28) + day + (year * 12 * 28);
    }
}