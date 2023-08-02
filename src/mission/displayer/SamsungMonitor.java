package mission.displayer;

// 삼성 모니터 만의 데이터 및 기능을 정의함.
public class SamsungMonitor extends Monitor {
    private boolean blueLightBlock; // 블루라이트 필터

    public SamsungMonitor(String company, int HORIZONTAL, int VERTICAL, boolean blueLightBlock) {
        super(company, HORIZONTAL, VERTICAL);
        this.blueLightBlock = blueLightBlock;
    }

    @Override
    public void setting() {
        String input;

        while (true) {
            printSetting();
            input = super.scanner.nextLine();
            if (input.equals("1")) blueLightBlock = !blueLightBlock; // 사용자가 1입력 -> 반전된 값 저장
            else if (input.equals("2")) break;
            else System.out.println("Wrong command inserted.");
        }
    }

    // 삼성 모니터에서 제공하는 환경 설정 내용 및 현재 상태를 출력한다.
    private void printSetting() {
        System.out.println("Blue light block : " + blueLightBlock);
        System.out.println("(1)_Toggle (2)_Back");
    }
}
