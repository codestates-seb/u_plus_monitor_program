package mission;

import mission.displayer.LGMonitor;
import mission.computer.Computer;

public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer(new LGMonitor(50, 10, false));
        computer.operate();
    }
}