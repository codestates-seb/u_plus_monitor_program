package mission.displayer;

import java.util.Scanner;

// 모니터라면 마땅히 가지는 공통적인 데이터와 기능들을 추상화한 클래스
public class Monitor implements Display {
    private String company;         // 모니터 이름
    private int horizontal;        // 화면 너비
    private int vertical;          // 화면 높이
    protected Scanner scanner = new Scanner(System.in);

    // 생성자를 통해 화면의 크기를 인자로 받아온다.


    public Monitor() {}

    public Monitor(String company, int HORIZONTAL, int VERTICAL) {
        this.company = company;
        this.horizontal = HORIZONTAL;
        this.vertical = VERTICAL;
    }

    @Override
    // 연결을 수행한다.
    public void connect() {
        output(company + " monitor is connected.");
    }

    @Override
    // 화면을 출력한다.
    public void output(String content) {

        if (!isValidLength(content)) content = "Invalid content length.";
        System.out.println("-".repeat(horizontal));
        System.out.printf("%s\n", composeScreen(content));
        System.out.println("-".repeat(horizontal));
    }

    // 입력 문자열의 길이가 화면을 벗어나지 않는지 체크한다.
    protected boolean isValidLength(String content) {
        return content.length() <= (horizontal - 4) * vertical;

        // 참고 : HORIZONTAL - 4에서 -4는 좌우 베젤을 의미
    }

    // 화면에 출력할 내용을 구성한다.
    protected String composeScreen(String str) {

        // 첫 글자만 포함한 스트링 빌더 생성
        StringBuilder stringBuilder = new StringBuilder(str.charAt(0) + "");

        // 문자열의 1번 인덱스부터 마지막 인덱스까지 순회하면서
        for (int i = 1; i < str.length(); i++) {

            // 스트링 빌더에 포함된 문자열에 하나씩 연결한다.
            stringBuilder.append(str.charAt(i));

            // 매 줄마다 화면의 가로 최대 범위에 도달하면 개행을 추가한다.
            if (i % (horizontal - 1) == 0) stringBuilder.append("\n");
        }

        // 문자열의 길이에 따라 화면의 세로 길이가 영향을 받지 않도록 개행 문자를 추가한다.
        stringBuilder.append("\n".repeat(vertical - str.length() / (horizontal - 1)));

        // 문자열로 변환하여 리턴한다.
        return stringBuilder.toString();
    }
}
