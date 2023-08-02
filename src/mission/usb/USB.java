package mission.usb;

// USB 인터페이스를 구현하는 클래스들이 갖춰야 할 일종의 조건을 명세함.
public interface USB {
    void connect(); // 포트 연결 방법을 구현 클래스가 구현하도록 강제하는 추상 메서드
}
