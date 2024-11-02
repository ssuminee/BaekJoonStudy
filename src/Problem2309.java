import java.io.*;
import java.util.Arrays;

public class Problem2309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];    // 아홉 난장이
        int sum = 0;    // 아홉 난장이 합계

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        int firstLier = 0;    // 첫번째 구라쟁이
        int secondLier = 0;    // 두번째 구라쟁이

        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    firstLier = arr[i];
                    secondLier = arr[j];
                    break;
                }
            }
        }

        Arrays.sort(arr);

        for(int i = 0; i < 9; i++) {
            if(arr[i] != firstLier && arr[i] != secondLier) {
                System.out.println(arr[i]);
            }
        }
    }
}
