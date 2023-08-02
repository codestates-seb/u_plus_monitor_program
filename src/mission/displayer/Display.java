package mission.displayer;

// Display 인터페이스를 구현하는 클래스들이 갖춰야 할 일종의 조건을 명세함.
public interface Display {
    void output(String content);   // 화면을 출력할 수 있어야 한다.
    void connect();                // 컴퓨터와 연결할 수 있어야 한다.
}
