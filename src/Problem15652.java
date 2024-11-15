import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15652 {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        nm(0, 1);
        System.out.println(sb);
    }

    public static void nm(int index, int start) {
        if(index == m) {
            for(int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i <= n; i++) {
            arr[index] = i;
            nm(index + 1, i);
        }
    }
}
