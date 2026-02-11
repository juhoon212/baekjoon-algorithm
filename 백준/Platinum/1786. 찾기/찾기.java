import java.util.*;
import java.io.*;

class Main {
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String parent = br.readLine();
        String pattern = br.readLine();
        
        List<Integer> pos = KMP(parent, pattern);
        System.out.println(count);
        
        pos.stream().forEach(it -> System.out.print(it + " "));
    }
    
    static List<Integer> KMP(String parent, String pattern) {
        int j=0;
        List<Integer> pos = new ArrayList<>();
        
        int[] failArr = makeFailArr(pattern);
        for (int i=0; i<parent.length(); ++i) {
            while (j>0 && parent.charAt(i) != pattern.charAt(j)) {
                j = failArr[j-1];
            }
            
            if (parent.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length()-1) {
                    count++;
                    pos.add(i - pattern.length() + 2);
                    j = failArr[j];
                } else {
                    ++j;
                }
            }
        }
        return pos;
    }
    
    static int[] makeFailArr(String pattern) {
        int j=0;
        int[] failArr = new int[pattern.length()];
        for (int i=1; i<pattern.length(); ++i) {
            while (j>0 && pattern.charAt(j) != pattern.charAt(i)) {
                j = failArr[j-1];
            }
            
            if (pattern.charAt(i) == pattern.charAt(j)) {
                failArr[i] = ++j;
            }
        }
        return failArr;
    }
}