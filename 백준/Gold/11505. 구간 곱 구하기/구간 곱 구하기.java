
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M,K;
    static int MOD = 1000000007;
    static long[] tree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 1. 트리의 크기 구하기
        int h = 0;
        int l = N;
        while(l != 0){
            l /= 2;
            h++;
        }
        int size = (int) Math.pow(2,h+1);

        // 2. 원본 데이터 채우기(시작 인덱스 구하기)
        int start = size/2 -1;
        tree = new long[size+1];
        Arrays.fill(tree,1);
        for(int i=1;i<=N;i++) tree[i+start] = Long.parseLong(br.readLine());

        // 3. 나머지 데이터 채우기
        int idx = size-1;
        while(idx != 1){
            tree[idx/2] = tree[idx/2] * tree[idx]%MOD;
            idx--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            // 4. 인덱스 변환 : start+b
            // 5. 두 노드의 값 스위칭
            if(a == 1) change(start+b, c);
                // 6. 질의값 구하기
            else if(a == 2){
                b += start;
                c += start;
                // 7. 데이터 업데이트하기
                sb.append(getVal(b,(int)c)).append("\n");
            }
            else return;
        }
        System.out.println(sb);
    }

    // 6. 질의값 구하기
    static long getVal(int s, int e){
        long val = 1;
        while(s <= e){
            if(s%2 == 1){
                val = val * tree[s] % MOD;
                s++;
            }
            if(e%2 == 0){
                val = val * tree[e]%MOD;
                e--;
            }

            s /= 2;
            e /= 2;
        }
        return val;
    }

    // 5. 두 노드의 값 스위칭
    static void change(int idx, long val){
        tree[idx] = val;
        while(idx > 1){
            idx /= 2;
            tree[idx] = tree[idx*2]%MOD * tree[idx*2+1]%MOD;
        }
    }
}
