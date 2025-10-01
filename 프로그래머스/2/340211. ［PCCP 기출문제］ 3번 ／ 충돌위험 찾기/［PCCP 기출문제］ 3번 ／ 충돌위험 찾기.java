import java.util.*;

class Solution {
    static class Point {
        int r;
        int c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Position {
        int t;   
        int x;
        int y;

        public Position(int t, int x, int y) {
            this.t = t;
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Position)) return false;
            Position p = (Position) o;
            return (this.t == p.t) && (this.x == p.x) && (this.y == p.y);
        }

        public int hashCode() {
            return Objects.hash(t, x, y);
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer=0;

        Map<Integer, Point> pointMap = new HashMap<>();
        int index=0;
        for (int[] point : points) addPoint(point, pointMap, ++index);

        // 한칸씩 옮길떄마다 상태를 기록해야한다.
        List<Position> posList = new ArrayList<>();

        for (int[] route : routes) {
            Point fromPt = pointMap.get(route[0]);
            int curR = fromPt.r;
            int curC = fromPt.c;
            int time = 0;

            posList.add(new Position(time, curR, curC)); // 시작 위치 기록

            for (int k=1; k<route.length; k++) {
                Point toPt = pointMap.get(route[k]);

                // r먼저
                while (curR != toPt.r) {
                    curR += (toPt.r > curR) ? 1 : -1;  
                    time++;
                    posList.add(new Position(time, curR, curC));
                }

                // 그다음 c
                while (curC != toPt.c) {
                    curC += (toPt.c > curC) ? 1 : -1; 
                    time++;
                    posList.add(new Position(time, curR, curC));
                }
            }
        }

        // 중복된 position이 있다면 answer++
        Set<Position> seen = new HashSet<>();
        Set<Position> duplicated = new HashSet<>();
        for (Position p : posList) {
            if (!seen.add(p)) duplicated.add(p);
        }
        answer = duplicated.size();

        return answer;
    }

    void addPoint(int[] point, Map<Integer, Point> pointMap, int index) {
        Point p = new Point(point[0], point[1]);
        pointMap.put(index, p);
    }
}
