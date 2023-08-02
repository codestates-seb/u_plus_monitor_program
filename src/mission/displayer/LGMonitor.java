package mission.displayer;

public class LGMonitor extends Monitor implements Displayer {

    private int monitorStandLevel;

    public LGMonitor(int HORIZONTAL, int VERTICAL, int monitorStandLevel) {
        super(HORIZONTAL, VERTICAL);
        this.monitorStandLevel = monitorStandLevel;
    }

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    @Override
    public void connect() {
        super.connect("LG");
    }

    @Override
    public void printDisplay(String content) {
        super.printDisplay(content);
    }

    public void configureSetting() {

        String input;

        while (true) {
            printSetting();
            input = super.scanner.nextLine();
            if (input.equals("1")) {
                if (monitorStandLevel == 3) monitorStandLevel = 1;
                else monitorStandLevel += 1;
            }
            else if (input.equals("2")) break;
        }
    }

    private void printSetting() {
        System.out.println("Monitor stand level : " + monitorStandLevel);
        System.out.println("(1)_Up (2)_Back");
    }
}
