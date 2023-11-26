import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            int startIdx = 1;
            int endIdx = 1;

            int sum = 1;
            int count = 1; // 자기자신

            while(endIdx != N) {
                if(sum == N) {
                    count++;
                    endIdx++;
                    sum += endIdx;
                } else if(sum > N) {
                    sum -= startIdx;
                    startIdx++;
                } else {
                    endIdx++;
                    sum += endIdx;
                }

           
            }
             System.out.println(count);
        }
    }
