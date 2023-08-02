package mission.displayer;

import mission.usb.USB;

// Displayer 인터페이스를 구현하는 클래스들이 갖춰야 할 일종의 조건을 명세함.
public interface Displayer extends USB { // USB 인터페이스 상속
    void printDisplay(String content);   // Displayer 인터페이스를 구현하는 클래스라면 화면을 출력할 수 있어야 한다.
    boolean isConnected();               // Displayer 인터페이스를 구현하는 클래스라면 연결 상태를 확인할 수 있어야 한다.
    void configureSetting();             // Displayer 인터페이스를 구현하는 클래스라면 환경 설정을 할 수 있어야 한다.
}
