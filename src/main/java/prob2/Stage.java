package prob2;

import java.util.StringTokenizer;

public class Stage {
    private String originMap; // 원래의 맵 정보
    private String byteMap; // 변환된 맵 정보
    private int rowSize = 0; // 세로 크기
    private int colSize = 0; // 가로 크기
    private int hallCount = 0; // 구멍의 수
    private int ballCount = 0; // 공의 수
    private int[] player = new int[2]; // 플레이어 위치 [행, 열]
    private int stageNum; // 스테이지 번호

    Stage(String originMap, int stageNum) {
        this.originMap = originMap;
        this.stageNum = stageNum;
        setDatas(originMap);
    }

    /**
     *  맵 정보에 기반해 Stage 클래스의 멤버변수를 설정하는 함수
     *
     * @param originMap 맵 정보 문자열
     */
    private void setDatas(String originMap) {

        int rowSize = 0;
        String byteMap = "";
        StringTokenizer st = new StringTokenizer(originMap, "\n");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            String[] tokens = token.split("");
            if (tokens.length > this.colSize) {
                this.colSize = tokens.length;
            }

            // 토큰을 읽어들일 때 마다 더하여 총 row 값을 계산
            rowSize++;

            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i].equals("O")) {
                    byteMap += "1";
                    this.hallCount++;
                } else if (tokens[i].equals("o")) {
                    byteMap += "2";
                    this.ballCount++;
                } else if (tokens[i].equals("P")) {
                    byteMap += "3";
                    this.player[0] = rowSize; // P의 row 값 (세로 크기)
                    this.player[1] = i + 1; // P의 열 값 (가로 크기)
                } else if (tokens[i].equals("#")) {
                    byteMap += "4";
                } else {
                    byteMap += "0";
                }
            }

            byteMap += "\n";
        }

        this.byteMap = byteMap;
        this.rowSize = rowSize;

    }
}
