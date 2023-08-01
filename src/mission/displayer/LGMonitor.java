package mission.displayer;

public class LGMonitor extends Monitor implements Displayer {

    private boolean monitorStandLevel;

    public LGMonitor(int HORIZONTAL, int VERTICAL, boolean monitorStandLevel) {
        super(HORIZONTAL, VERTICAL);
        this.monitorStandLevel = monitorStandLevel;
    }

    @Override
    public boolean isConnected() {
        return super.isConnected();
    }

    @Override
    public void connect() {
        super.connect();
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
            if (input.equals("1")) monitorStandLevel = !monitorStandLevel;
            else if (input.equals("2")) break;
        }
    }

    private void printSetting() {
        System.out.println("Blue light block : " + monitorStandLevel);
        System.out.println("(1)_Toggle (2)_Back");
    }
}
