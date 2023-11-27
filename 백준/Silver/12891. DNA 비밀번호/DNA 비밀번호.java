

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
    static int count;
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
            int P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분문자열 길이
            count = 0; // 비밀번호 종류의 수
            checkArr = new int[4];
            myArr = new int[4];
            char A[] = new char[S];
            int result = 0;

            A = br.readLine().toCharArray();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                checkArr[i] = Integer.parseInt(st.nextToken());
                if(checkArr[i] == 0) {
                    count++;
                }
            }

            for (int i = 0; i < P; i++) {
                getAdd(A[i]); // 부분문자열 처음 받을떄 세팅
            }

            if(count == 4) result++;

            // 슬라이딩윈도우
            for (int i = P; i < S ; i++) {
                int j = i - P; // 범위를 유지하면서 이동.
                getAdd(A[i]);
                remove(A[j]);
                if(count == 4) result++;
            }

        System.out.println(result);
            br.close();
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if(myArr[0] == checkArr[0]) count--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]) count--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]) count--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]) count--;
                myArr[3]--;
                break;
        }
    }

    private static void getAdd(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]) count++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]) count++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]) count++;
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]) count++;
                break;

        }
    }
}
