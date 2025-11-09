import java.util.*;

class Solution {
    // 각 유저는 한번에 한명 유저 신고 가능
    // 신고 횟수 제한x 
    // 서로 다른 유저 계속 신고 가능
    // 한 유저가 동일 유저를 여러번 신고 시 -> 무조건 1회로 기록
    // k번 이상 신고된 유저는 게시판 이용 정지
    static class Person {
        String from;
        String to;
        
        public Person(String from, String to) {
            this.from = from;
            this.to = to;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Person)) return false;
            Person p = (Person) o;
            return this.from.equals(p.from) && 
                this.to.equals(p.to);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        // report들 set에 Person 객체로 담기
        // 중복(동일한 from ~ to)된 건 collection에 집어넣을 때 알아서 걸러짐
        Set<Person> set = new HashSet<>();
        for (String targets : report) {
            String[] target = targets.split(" ");
            Person now = new Person(target[0], target[1]);
            set.add(now);
        }
        
        // 유저별 신고당한 횟수
        Map<String, Integer> cntMap = new HashMap<>();
        for (Person target : set) {            
            cntMap.put(target.to, cntMap.getOrDefault(target.to, 0) + 1);
        }
        
        // 결과 알림한 횟수
        Map<String, Integer> result = new HashMap<>();
        for (Person p : set) {
            // 신고횟수가 k보다 높거나 같으면 알림 map에 저장
            // from을 저장해야 신고한사람에게 알림이 감.
            if (cntMap.getOrDefault(p.to, 0) >= k) {
                result.put(p.from, result.getOrDefault(p.from, 0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i=0; i<id_list.length; ++i) {
            answer[i] = result.getOrDefault(id_list[i], 0);
        }
        return answer;
    }
}