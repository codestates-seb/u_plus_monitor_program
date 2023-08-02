package mission.displayer;

// 삼성 모니터 만의 데이터 및 기능을 정의함.
public class SamsungMonitor extends Monitor implements Displayer {
    private boolean blueLightBlock; // 블루라이트 필터

    public SamsungMonitor(int HORIZONTAL, int VERTICAL, boolean blueLightBlock) {
        super(HORIZONTAL, VERTICAL); // 상위 클래스 생성자 호출
        this.blueLightBlock = blueLightBlock;
    }

    // 인터페이스 구현 메서드 : 연결 상태를 확인한다.
    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    // 인터페이스 구현 메서드 : 연결을 수행한다.
    @Override
    public void connect() {
        super.connect("Samsung");
    }

    // 인터페이스 구현 메서드 : 화면을 출력한다.
    @Override
    public void printDisplay(String content) {
        super.printDisplay(content);
    }

    // 인터페이스 구현 메서드 : 환경을 설정한다.
    public void configureSetting() {

        String input;

        while (true) {
            printSetting();
            input = super.scanner.nextLine();
            if (input.equals("1")) blueLightBlock = !blueLightBlock; // 사용자가 1입력 -> 반전된 값 저장
            else if (input.equals("2")) break;
        }
    }

    // 삼성 모니터에서 제공하는 환경 설정 내용 및 현재 상태를 출력한다.
    private void printSetting() {
        System.out.println("Blue light block : " + blueLightBlock);
        System.out.println("(1)_Toggle (2)_Back");
    }
}
