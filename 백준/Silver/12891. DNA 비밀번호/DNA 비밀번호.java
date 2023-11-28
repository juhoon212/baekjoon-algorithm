

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

    static int[] myArr;
    static int[] checkArr;
    static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        checkArr = new int[4];
        myArr = new int[4];
        check = 0;
        int result = 0;

        char[] charArr = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken()); // 들어오는 수 저장
            if(checkArr[i] == 0) {
                check++; // 들어오는 수가 0 이면 셀 필요가 없으므로 + 1 을 해준다.
            }
        }

        for (int i = 0; i < P; i++) {
            checkAndAddAlphabet(charArr[i]);
        }

        if (check == 4) result++;

        // 슬라이딩 윈도우(1칸 올려서 카운트)
        for (int i = P; i < S; i++) {
            int j = i - P;

            checkAndAddAlphabet(charArr[i]);
            checkAndRemoveAlphabet(charArr[j]);
            if(check == 4) result++;
        }

        System.out.println(result);
        br.close();

    }

    private static void checkAndAddAlphabet(char c) {
        switch (c) {
            case'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    check++;
                }
                break;
            case'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    check++;
                }
                break;
            case'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    check++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3] ) {
                    check++;
                }
                break;
        }

    }

    /**
     *
     * 먼저 앞에 있던 문자열을 뺴주는 역할을 한다.
     */
    private static void checkAndRemoveAlphabet(char c) {
        switch (c) {
            case'A':
                if (myArr[0] == checkArr[0]) {
                    check--;
                }
                myArr[0]--;
                break;
            case'C':
                if (myArr[1] == checkArr[1]) {
                    check--;
                }
                myArr[1]--;
                break;
            case'G':
                if (myArr[2] == checkArr[2]) {
                    check--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    check--;
                }
                myArr[3]--;
                break;
        }
    }
}
