package mission;

import mission.displayer.LGMonitor;
import mission.computer.Computer;
import mission.displayer.SamsungMonitor;

public class Main {
    public static void main(String[] args) {

        // 사용할 모니터를 삼성 모니터로 선택
        // Computer 생성자의 인자만 바꾸면 다른 수정 없이 모니터를 교체할 수 있다.
        Computer computer = new Computer(
                new SamsungMonitor(
                        50, 10, false
                )
        );
        computer.operate(); // 컴퓨터 동작 시작
    }
}