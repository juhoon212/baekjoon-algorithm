public class Main {

    public static void main(String[] args) {

        // 33 -> 33 + 3 + 3 = 39
        // 39 -> 39 + 3 + 9 = 51

        // 33은 39의 생성자, 생성자가 1개보다 많은 경우가 있다.
        // 생성자가 없으면 셀프 넘버이다.

        boolean arr[] = new boolean[10001];
        for (int i = 1; i < 10000; ++i) {

            // 11 -> 11 + 1 + 1
            int copy = i;
            String iString = String.valueOf(i);

            int length = iString.length();

            // 1111
            for (int j = 0; j < length; ++j) {
                int splitNum= Integer.parseInt(iString.substring(j, j + 1));
                copy += splitNum; // copy 가 생성자가 있는 수
            }

            if (copy < 10001) {
                arr[copy] = true;
            }
        }

        for (int k = 1; k < 10001; ++k) {
            if (!arr[k]) {
                System.out.println(k);
            }
        }
    }
}
