class Solution {
    static class Student {
        int size;
        boolean hasTraining;
        
        public Student(int size, boolean hasTraining) {
            this.size = size;
            this.hasTraining = hasTraining;
        }
        
        public void changeStatus(int size, boolean hasTraining) {
            this.size = size;
            this.hasTraining = hasTraining;
        }
        
        public void changeSize(int size) {
            this.size = size;
        }
        
         public void decrease() {
            this.size--;
        }
        
        public String toString() {
            return String.format("size = %d, hasTraining = %s", size, hasTraining);
        }
    }
    public int solution(int n, int[] lost, int[] reserve) {
        Student[] arr = new Student[n+2]; // 양쪽 경계 안전용

        for (int i = 1; i <= n; i++) arr[i] = new Student(1, true);

        boolean[] lostCheck = new boolean[n+1];
        boolean[] reserveCheck = new boolean[n+1];

        for (int l : lost) lostCheck[l] = true;
        for (int r : reserve) reserveCheck[r] = true;

        // 겹치는 학생 제거
        for (int i = 1; i <= n; i++) {
            if (lostCheck[i] && reserveCheck[i]) {
                lostCheck[i] = false;
                reserveCheck[i] = false;
            }
        }

        // 진짜 잃어버린 학생 처리
        for (int i = 1; i <= n; i++) {
            if (lostCheck[i]) {
                arr[i].changeStatus(0, false);
            }
        }

        // 여벌 처리
        for (int i = 1; i <= n; i++) {
            if (reserveCheck[i]) {
                arr[i].size = 2;
            }
        }

        // 빌리기
        for (int i = 1; i <= n; i++) {
            if (arr[i].size == 0) {

                if (i > 1 && arr[i-1].size > 1) {
                    arr[i-1].decrease();
                    arr[i].changeStatus(1, true);
                }
                else if (i < n && arr[i+1].size > 1) {
                    arr[i+1].decrease();
                    arr[i].changeStatus(1, true);
                }
            }
        }
        
        // hasTraining이 true 인것들만 count
        int count = 0;
        for (int i=1; i<n+1; ++i) {
            if (arr[i].hasTraining) count++;
        }
        return count;
    }
}