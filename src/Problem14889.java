import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14889 {
    static int memberCnt = 0;    // 참가자
    static int stat[][];   // 능력치
    static int minDiff = Integer.MAX_VALUE;    // 두팀의 차이
    static boolean check[]; // 방문 여부

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        memberCnt = Integer.parseInt(br.readLine());
        stat = new int[memberCnt][memberCnt];
        check = new boolean[memberCnt];

        // 능력치 세팅
        for(int i = 0; i < memberCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < memberCnt; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calcDiff(0, 0);

        System.out.println(minDiff);
    }

    public static void calcDiff(int index, int teamCnt) {
        if(teamCnt == memberCnt / 2) {
            int start = 0;
            int link = 0;

            for(int i = 0; i < memberCnt- 1; i++) {
                for(int j = i + 1; j < memberCnt; j++) {
                    if(check[i] && check[j]) {
                        start += stat[i][j];
                        start += stat[j][i];
                    } else if(!check[i] && !check[j]) {
                        link += stat[i][j];
                        link += stat[j][i];
                    }
                }
            }

            int minus = Math.abs(start - link);

            // 차이가 0이면 어차피 결과는 0이니까
            if(minus == 0) {
                System.out.println(0);
                System.exit(0);
            }

            minDiff = Math.min(minus, minDiff);
            return;
        }

        for(int i = index; i < memberCnt; i++) {
            if(!check[i]) {
                check[i] = true;
                calcDiff(i + 1, teamCnt + 1);
                check[i] = false;
            }
        }
    }
}
