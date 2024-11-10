import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 카드 장 수
        int m = Integer.parseInt(st.nextToken());   // 카드 합 제한
        st = new StringTokenizer(br.readLine());    // 카드 숫자
        int[] numArr = new int[n];

        // 입력한 카드 숫자 세팅
        for(int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = 0;
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    int sum = numArr[i] + numArr[j] + numArr[k];
                    if(sum <= m) {
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }

        System.out.println(maxSum);
    }
}
