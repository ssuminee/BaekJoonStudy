import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Problem2503 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());    // 물어본 횟수
        boolean[] answer = new boolean[1000];    // 답 가능성

        // 가능성 있는 숫자 선별
        for(int i = 123; i <= 987; i++) {
            // 3개 숫자가 겹치면 안되고 0 이면 안됨
            int hundred = i / 100;
            int ten = (i % 100) / 10;
            int one = i % 10;

            if(hundred == 0 || ten == 0 || one == 0) continue;
            if(hundred == ten || hundred == one || ten == one) continue;
            answer[i] = true;
        }

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());    // 입력한 숫자
            int inputStrike = Integer.parseInt(st.nextToken());  // 스트라이크
            int inputBall = Integer.parseInt(st.nextToken());    // 볼

            for(int j = 123; j <= 987; j++) {
                if(answer[j]) {    // 정답 가능성이 있는 숫자만 체크

                    int strike = 0;
                    int ball = 0;

                    for(int input = 0; input < 3; input++) {    // 입력한 숫자의 자리수
                        char inputChar = Integer.toString(num).charAt(input);

                        for(int ans = 0; ans < 3; ans++) {    // 정답일수도 있는 숫자의 자리수
                            char ansChar = Integer.toString(j).charAt(ans);

                            // 스트라이크일 경우
                            if(ans == input && inputChar == ansChar) {
                                strike++;
                            } else if(ans != input && inputChar == ansChar) {    // 볼일 경우
                                ball++;
                            }
                        }
                    }

                    // 정답가능성 체크
                    if(strike == inputStrike && ball == inputBall) {
                        answer[j] = true;
                    } else {
                        answer[j] = false;
                    }
                }
            }
        }


        int answerCnt = 0;
        for(int i = 123; i <= 987; i++) {
            if(answer[i]) answerCnt++;
        }

        System.out.println(answerCnt);
    }
}
