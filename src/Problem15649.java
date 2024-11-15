import java.io.*;
import java.util.StringTokenizer;

public class Problem15649 {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static boolean[] dupl;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dupl = new boolean[n + 1];

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
                arr[index] = i;
                nm(index + 1);
                dupl[i] = false;
            }
        }
    }
}
