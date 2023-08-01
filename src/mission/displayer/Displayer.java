package mission.displayer;

import mission.computer.USB;

public interface Displayer extends USB {
    void printDisplay(String content);
    boolean isConnected();
    void configureSetting();
}
