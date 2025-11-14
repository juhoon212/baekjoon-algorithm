import java.util.*;

class Solution {
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
            return this.from.equals(p.from) && this.to.equals(p.to);
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
    public int[] solution(String[] id_list, String[] report, int k) {
        // a -> b를 신고할 시 +1, 동일 인물을 신고시에는 무조건 1회로 처리
        // k번이상 신고된 유저는 게시판 이용 정지, 이 사실을 메일로 전송
        
        // from ~ to가 같으면 어차피 1회로 처리되니 Set에 담는다.
        Set<Person> declarations = new HashSet<>();
        for (String s : report) {
            String[] now = s.split(" ");
            Person p = new Person(now[0], now[1]);
            declarations.add(p);
        }
        
        // 신고 당한 사람들의 횟수를 HashMap에 담는다. 조회 O(1)
        Map<String, Integer> reportedCnt = new HashMap<>();
        for (Person target : declarations) {
            String reportee = target.to;
            // 이미 있으면 거기다가 + 1, 아니면 0으로 초기화해서 넣기
            // 어차피 전에 set으로 동일 신고자 -> 피신고자는 걸렀음
            reportedCnt.put(reportee, reportedCnt.getOrDefault(reportee, 0) + 1);
        }
        
        // HashMap 하나 더 생성해서 Person을 돌면서 그 target 마다의 피신고자를 신고 횟수 map에서 검색
        // 그 횟수는 신고자의 정지 메일 전송 카운트와 같음
        Map<String, Integer> alarmCnt = new HashMap<>();
        for (Person target : declarations) {
            String reporter = target.from;
            String reportee = target.to;
            
            if (reportedCnt.getOrDefault(reportee, 0) >= k) {
                alarmCnt.put(reporter, alarmCnt.getOrDefault(reporter, 0) + 1);
            }
        }
        
        // 유저 id를 돌면서 alaramCnt에 있다면 그 value(횟수)를 반환 없다면 0 저장
        int[] answer = new int[id_list.length];
        for (int i=0; i<id_list.length; ++i) {
            String target = id_list[i];
            answer[i] = alarmCnt.getOrDefault(target, 0);
        }
        return answer;
    }
}