package mission;

import mission.displayer.LGMonitor;
import mission.computer.Computer;
import mission.displayer.SamsungMonitor;

public class Main {
    public static void main(String[] args) {


        Computer computer = new Computer(
//                new SamsungMonitor("Samsung", 50, 10, false)
        );
        computer.operate(); // 컴퓨터 동작 시작
    }
}