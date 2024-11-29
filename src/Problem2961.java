import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2961 {
   static int n;
   static int answer = Integer.MAX_VALUE;
   static int[][] ingredient;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());    // 재료 개수
        ingredient = new int[n][2]; // 재료

        // 재료 세팅
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ingredient[i][0] = Integer.parseInt(st.nextToken());    // 신맛
            ingredient[i][1] = Integer.parseInt(st.nextToken());    // 쓴맛
        }

        eat(0, 1, 0, 0);
        System.out.println(answer);
    }

    private static void eat(int depth, int sour, int bitter, int selectedCnt) {
        if(depth == n) {
            if(selectedCnt != 0 && Math.abs(sour - bitter) < answer) {
                answer = Math.abs(sour - bitter);
            }
            return;
        }

        eat(depth + 1, sour * ingredient[depth][0], bitter + ingredient[depth][1], selectedCnt + 1);    // 선택
        eat(depth + 1, sour, bitter, selectedCnt);  // 미선택
    }
}
