

import java.util.StringTokenizer;

public class Solution {

    public String solution(String s) {
        String[] splitArr = s.split(" ");

        int[] arr = new int[splitArr.length];
        int max, min, now;
        StringBuffer sb = new StringBuffer();

        max = min = Integer.parseInt(splitArr[0]);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(splitArr[i]);
            now = arr[i];
            if (now > max) max = now;
            if (now < min) min = now;
        }

        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
