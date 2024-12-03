
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // 2글자 묶음과 3글자 묶음으로 나뉨
    // ex) {dz=}, {c=, c-, d-, ...}

    public static void main(String[] args) throws IOException {

        // 입력을 받는다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        // 2글자, 3글자 분기 처리
        String etc = "dz=";
        List<String> list = new ArrayList<>();
        list.add("c=");
        list.add("c-");
        list.add("dz=");
        list.add("d-");
        list.add("lj");
        list.add("nj");
        list.add("s=");
        list.add("z=");

        int cnt = 0;

        for (int i=0; i<line.length();) {
            if (i < line.length() - 2 && etc.equals(line.substring(i, i + 3))) {
                cnt += 2;
                i += 3;
            } else if (i < line.length() - 1 && list.contains(line.substring(i, i + 2))) {
                cnt += 1;
                i += 2;
            } else {
                i++;
            }
        }

        System.out.println(line.length() - cnt);
    }
}
