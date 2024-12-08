import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14391 {
    public static int n, m;
    static int[][] rectangle;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rectangle = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                rectangle[i][j] = input.charAt(j) - '0';
            }
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(int depth, int num, int sum) {
        if(depth == n * m) {
            answer = Math.max(answer, sum);
            return;
        }

        int r = depth / m;
        int c = depth % m;

        if(visited[r][c]) {
            dfs(depth + 1, num, sum);
        } else {
            visited[r][c] = true;
            num = num * 10 + rectangle[r][c];
            dfs(depth + 1, 0, sum + num);

            int i = num;
            int temp = num;

            for(i = r + 1; i < n; i++) {
                if(visited[i][c]) {
                    break;
                }
                visited[i][c] = true;
                temp = temp * 10 + rectangle[i][c];
                dfs(depth + 1, 0, sum + temp);
            }

            for(int j = r + 1; j < i; j++) {
                visited[j][c] = false;
            }

            temp = num;
            for(i = c + 1; i < m; i++) {
                if(visited[r][i]) {
                    break;
                }
                visited[r][i] = true;
                temp = temp * 10 + rectangle[r][i];
                dfs(depth + 1 - c + 1, 0, sum + temp);
            }

            for(int j = c + 1; j <i; j++) {
                visited[r][j] = false;
            }
            visited[r][c] = false;
        }
    }
}
