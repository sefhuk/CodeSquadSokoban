package prob2;

import java.util.*;

public class Application {

    /**
     * 사용자로부터 전체 스테이지에 대한 맵 정보를 입력받는 함수
     *
     * @return 맵 정보가 담긴 문자열
     */
    public static String getInput() {

        Scanner sc = new Scanner(System.in);

        String input, str = "";
        while (sc.hasNextLine()) {
            input = sc.nextLine();

            if (input.contains("Stage")) {
                continue;
            }

            if (input.equals("")) {
                break;
            }

            str += input + "\n";
        }

        sc.close();

        return str;
    }
}
