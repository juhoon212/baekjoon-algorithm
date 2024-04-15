
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] tree = new int[26][2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            final int nowNode = st.nextToken().charAt(0) - 'A';
            final char left = st.nextToken().charAt(0);
            final char right = st.nextToken().charAt(0);

            if (left == '.') {
                tree[nowNode][0] = -1;
            } else {
                tree[nowNode][0] = left - 'A';
            }

            if (right == '.') {
                tree[nowNode][1] = -1;
            } else {
                tree[nowNode][1] = right - 'A';
            }
        }

        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }

    private static void preOrder(int num) {

        if (num == -1) {
            return;
        }

        System.out.print((char) (num + 'A'));
        preOrder(tree[num][0]);
        preOrder(tree[num][1]);
    }

    private static void inOrder(int num) {
        if (num == -1) {
            return;
        }

        inOrder(tree[num][0]);
        System.out.print((char) (num + 'A'));
        inOrder(tree[num][1]);
    }

    private static void postOrder(int num) {
        if (num == -1) {
            return;
        }

        postOrder(tree[num][0]);
        postOrder(tree[num][1]);
        System.out.print((char) (num + 'A'));
    }


}
