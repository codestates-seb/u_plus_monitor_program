package mission.computer;

import mission.displayer.Displayer;

import java.util.Scanner;

// 컴퓨터 역할을 담당하는 컴퓨터 클래스 : 프로그램 제어 로직 포함
public class Computer {
    private Displayer monitor; // 사용할 모니터를 할당 받을 인터페이스 타입의 참조 변수 선언
    private Scanner scanner = new Scanner(System.in);

    // Computer 인스턴스를 생성할 때 Monitor 인스턴스를 전달 받음.
    public Computer(Displayer monitor) {
        this.monitor = monitor;
    }

    // 프로그램 구동
    public void operate() {

        String input;

        while (true) {

            System.out.println("(1)_Connect (2)_Print (3)_Setting (4)_Terminate");

            input = scanner.nextLine();
            String inputContent;

            switch (input) {

                // 입력값이 1인 경우, 모니터를 연결한다.
                case "1":
                    monitor.connect();
                    break;

                // 입력값이 2인 경우, 연결 여부에 따라 화면에 출력할 내용을 결정하고, 화면을 출력한다.
                case "2":
                    inputContent = monitor.isConnected() ?
                    inputStr(true) :
                    inputStr(false);
                    monitor.printDisplay(inputContent);
                    break;

                // 입력값이 3인 경우, 환경설정 메서드를 호출한다.
                case "3":
                    monitor.configureSetting();
                    break;

                // 입력값이 4인 경우, 프로그램을 종료한다.
                case "4":
                    System.exit(0);

                // 잘못된 입력 처리
                default:
                    System.out.println("Wrong command inserted.");
            }
        }
    }

    // 사용자가 2번을 누른 경우(화면 출력) 연결 상태를 체크하여 연결 상태가 true인 경우에만 입력을 받는다.
    private String inputStr(boolean isConnected) {
        if (!isConnected) return "";
        System.out.print("Insert content : ");
        return scanner.nextLine();
    }
}
