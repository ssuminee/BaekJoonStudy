import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15653 {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static int[] num;
    public static int[] arr;
    public static boolean[] dupl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];   // 입력한 숫자
        arr = new int[m];   // 답
        dupl = new boolean[n + 1];

        // 입력한 숫자 배열로 세팅
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        nm(0);
        System.out.println(sb);
    }

    public static void nm(int index) {
        if(index == m) {
            for(int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(!dupl[i]) {
                dupl[i] = true;
                arr[index] = num[i - 1];
                nm(index + 1);
                dupl[i] = false;
            }
        }
    }
}
