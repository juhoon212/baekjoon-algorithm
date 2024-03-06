
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String line = st.nextToken();

        String[] split = line.split("-");

        int total = 0;

        for (int i = 0; i < split.length; i++) {

            int sum = sumSplitArr(split[i]);

            if(i == 0) {
                total += sum;
            } else {
                total -= sum;
            }
        }

        System.out.println(total);
        br.close();
    }

    private static int sumSplitArr(String s) {

        String[] split = s.split("[+]");

        int result = 0;

        for (int i = 0; i < split.length; i++) {

            result += Integer.parseInt(split[i]);
        }

        return result;
    }
}
