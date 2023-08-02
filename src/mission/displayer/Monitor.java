package mission.displayer;

import java.util.Scanner;

// 모니터라면 마땅히 가지는 공통적인 데이터와 기능들을 추상화한 클래스
public class Monitor {
    private boolean isConnected = false; // 연결 상태
    private final int HORIZONTAL;        // 화면 너비
    private final int VERTICAL;          // 화면 높이
    protected Scanner scanner = new Scanner(System.in);

    // 생성자를 통해 화면의 크기를 인자로 받아온다.
    public Monitor(int HORIZONTAL, int VERTICAL) {
        this.HORIZONTAL = HORIZONTAL;
        this.VERTICAL = VERTICAL;
    }

    // 연결 상태를 리턴하는 getter
    public boolean isConnected() {
        return isConnected;
    }

    // 연결을 수행한다.
    public void connect(String brand) {
        if (!isConnected) {
            isConnected = true;
            printDisplay(brand + " monitor is connected.");
        }
        else {
            printDisplay("Already connected.");
        }
    }

    // 화면을 출력한다.
    public void printDisplay(String content) {

        if (isConnected) {
            if (!isValidLength(content)) content = "Invalid content length.";
            System.out.println("-".repeat(HORIZONTAL));
            System.out.printf("%s\n", composeScreen(content));
            System.out.println("-".repeat(HORIZONTAL));
        }
        else {
            System.out.println("No signal");
        }
    }

    // 입력 문자열의 길이가 화면을 벗어나지 않는지 체크한다.
    private boolean isValidLength(String content) {
        return content.length() <= (HORIZONTAL - 4) * VERTICAL;

        // 참고 : HORIZONTAL - 4에서 -4는 좌우 베젤을 의미
    }

    // 화면에 출력할 내용을 구성한다.
    private String composeScreen(String str) {

        // 첫 글자만 포함한 스트링 빌더 생성
        StringBuilder stringBuilder = new StringBuilder(str.charAt(0) + "");

        // 문자열의 1번 인덱스부터 마지막 인덱스까지 순회하면서
        for (int i = 1; i < str.length(); i++) {

            // 스트링 빌더에 포함된 문자열에 하나씩 연결한다.
            stringBuilder.append(str.charAt(i));

            // 매 줄마다 화면의 가로 최대 범위에 도달하면 개행을 추가한다.
            if (i % (HORIZONTAL - 1) == 0) stringBuilder.append("\n");
        }

        // 문자열의 길이에 따라 화면의 세로 길이가 영향을 받지 않도록 개행 문자를 추가한다.
        stringBuilder.append("\n".repeat(VERTICAL - str.length() / (HORIZONTAL - 1)));

        // 문자열로 변환하여 리턴한다.
        return stringBuilder.toString();
    }
}
