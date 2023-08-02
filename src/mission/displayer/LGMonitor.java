package mission.displayer;

// LG 모니터 만의 데이터 및 기능을 정의함.
public class LGMonitor extends Monitor {

    private int monitorStandLevel; // 모니터 스탠드 높이

    public LGMonitor(String company, int HORIZONTAL, int VERTICAL, int monitorStandLevel) {
        super(company, HORIZONTAL, VERTICAL);
        this.monitorStandLevel = monitorStandLevel;
    }

    @Override
    public void setting() {
        String input;

        // 사용자가 2를 누를 때까지 환경 설정 화면을 계속해서 보여준다.
        while (true) {
            printSetting();
            input = super.scanner.nextLine();
            if (input.equals("1")) {
                if (monitorStandLevel == 3) monitorStandLevel = 1; // 사용자가 Up 입력 + 현재 상태가 최대값이면 다시 1로 회귀
                else monitorStandLevel += 1;                       // 사용자가 Up 입력 + 현재 상태가 최대값이 아니면 1단 증가
            }
            else if (input.equals("2")) break;
            else System.out.println("Wrong command inserted.");
        }
    }

    // LG 모니터에서 제공하는 환경 설정 내용 및 현재 상태를 출력한다.
    private void printSetting() {
        System.out.println("Monitor stand level : " + monitorStandLevel);
        System.out.println("(1)_Up (2)_Back");
    }
}
