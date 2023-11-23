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

    /**
     * 사용자가 입력한 맵 정보를 스테이지 별로 분리하는 함수
     *
     * @param input 사용자가 입력한 맵 정보 문자열
     * @return 스테이지 순서대로 각 정보 문자열을 담은 List
     */
    public static List<String> tokenize(String input) {

        List<String> list = new ArrayList<>();

        String[] a = input.split("=====\n");
        for (String i : a) {
            list.add(i);
        }

        return list;
    }

    /**
     * 맵 정보에 따른 Stage 객체를 생성하는 함수
     *
     * @param tokens 맵 정보 문자열의 토큰들이 담긴 List
     * @return 각 맵에 대한 Stage 객체를 가진 List
     */
    public static List<Stage> generateStage(List<String> tokens) {

        List<Stage> stageList = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            Stage stage = new Stage(tokens.get(i), i + 1);
            stageList.add(stage);
        }

        return stageList;
    }
}
