import java.util.*;

class Solution {
    // (r,c) 와 같은 n개의 포인트 존재
    // 로봇마다 정해진 운송 경로 존재 m개의 포인트 존재
    // 로봇은 x대, 1초마다 r 또는 c 좌표 중 하나가 1만큼 감소하거나, 증가한 좌표로 이동 가능
    // 최단 경로로만 이동, 여러가지일 경우 c보단 r 좌표 우선이동
    // 이동 중 같은 좌표에 로봇이 2대 이상 모인다면 충돌할 가능성이 있는 위험 상황으로 인지
    static class Robot {
        int x;
        int y;
        
        public Robot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static class Position {
        int current;
        int x;
        int y;
        
        public Position(int current, int x, int y) {
            this.current = current;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (!(o instanceof Position)) return false;
            Position p = (Position) o;
            return this.current == p.current && this.x == p.x && this.y == p.y;
        } 
        @Override
        public int hashCode() {
            return Objects.hash(current, x, y);
        }
    }
    public int solution(int[][] points, int[][] routes) {
        // 초마다 현재 로봇이 어디 위치에 있는지 알아야 한다.
        // points[i] 각 로봇의 출발좌표
        int idx=1;
        Map<Integer, Robot> robotMap = new HashMap<>();
        for (int[] point : points) robotMap.put(
            idx++, new Robot(point[0], point[1]));
        
        List<Position> pos = new ArrayList<>();
        for (int[] route : routes) {
            Robot from = robotMap.get(route[0]);
            int curX = from.x;
            int curY = from.y;
            int time=0;
            pos.add(new Position(time, from.x, from.y));
            
            for (int i=1; i<route.length; ++i) {
                // r먼저
                Robot to = robotMap.get(route[i]);
                
                while (curX != to.x) {
                    curX += (curX > to.x) ? -1 : 1;
                    time++;
                    pos.add(new Position(time, curX, curY));
                }

                while (curY != to.y) {
                    curY += (curY > to.y) ? -1 : 1;
                    time++;
                    pos.add(new Position(time, curX, curY));
                }
            }
        }
        
        int answer=0;
        // 중복된 position이 있다면 answer++
        Set<Position> seen = new HashSet<>();
        Set<Position> duplicated = new HashSet<>();
        for (Position p : pos) {
            if (!seen.add(p)) duplicated.add(p);
        }
        answer = duplicated.size();

        return answer;
    }
}
