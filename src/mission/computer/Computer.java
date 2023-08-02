package mission.computer;

import mission.displayer.LGMonitor;
import mission.displayer.Monitor;
import mission.displayer.SamsungMonitor;

import java.util.Scanner;

// 컴퓨터 역할을 담당하는 컴퓨터 클래스 : 프로그램 제어 로직 포함
public class Computer {
    private Monitor monitor;
    private Scanner scanner = new Scanner(System.in);

//    public Computer(Monitor monitor) {
//        this.monitor = monitor;
//    }

    // 프로그램 구동
    public void operate() {

        String input;

        while (true) {

            System.out.println("(1)_Connect (2)_Print (3)_Setting (4)_Terminate");

            input = scanner.nextLine();

            switch (input) {

                // 입력값이 1인 경우, 모니터를 선택하여 연결한다.
                case "1":
                    convertMonitor();
//                    monitor.connect();
                    break;

                // 입력값이 2인 경우, 연결 여부에 따라 화면에 출력할 내용을 결정하고, 화면을 출력한다.
                case "2":
                    if (monitor != null) monitor.output(inputStr());
                    else System.out.println("No signal.");
                    break;

                // 입력값이 3인 경우, 환경설정 메서드를 호출한다.
                case "3":
                    if (monitor != null) monitor.setting();
                    else System.out.println("No signal.");
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

    // 모니터를 선택하고 연결한다.
    private void convertMonitor() {

        String input;
        System.out.println("(1)_Samsung (2)_LG (3)_Disconnect");
        input = scanner.nextLine();
        if (input.equals("1")) {
            monitor = new SamsungMonitor("Samsung", 50, 10, true);
            monitor.connect();
        }
        else if (input.equals("2")) {
            monitor = new LGMonitor("LG", 60, 8, 1);
            monitor.connect();
        }
        else if (input.equals("3")) {
            monitor = null;
            System.out.println("Disconnected");
        }
        else {
            System.out.println("Wrong command inserted.");
        }
    }

    // 사용자가 2번을 누른 경우(화면 출력) 연결 상태를 체크하여 연결 상태가 true인 경우에만 입력을 받는다.
    private String inputStr() {
        System.out.print("Insert content : ");
        return scanner.nextLine();
    }
}
