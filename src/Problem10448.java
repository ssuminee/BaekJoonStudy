import java.util.Arrays;
import java.io.*;

public class Problem10448 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());    // test case 개수
        int[] triArr = new int[45];    // 삼각수

        for(int i = 1; i < 45; i++) {
            triArr[i] = i * (i + 1) / 2;
        }

        for(int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());
            int result = check(num, triArr);
            System.out.println(result);
        }


    }

    public static int check(int num, int[] triArr) {
        for(int i = 1; i < 45; i++) {
            for(int j = 1; j < 45; j++) {
                for(int k = 1; k < 45; k++) {
                    if(triArr[i] + triArr[j] + triArr[k] == num) return 1;
                }
            }
        }
        return 0;
    }
}
