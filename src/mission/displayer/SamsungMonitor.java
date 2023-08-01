package mission.displayer;

public class SamsungMonitor extends Monitor implements Displayer {
    private boolean blueLightBlock;

    public SamsungMonitor(int HORIZONTAL, int VERTICAL, boolean blueLightBlock) {
        super(HORIZONTAL, VERTICAL);
        this.blueLightBlock = blueLightBlock;
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
            if (input.equals("1")) blueLightBlock = !blueLightBlock;
            else if (input.equals("2")) break;
        }
    }

    private void printSetting() {
        System.out.println("Blue light block : " + blueLightBlock);
        System.out.println("(1)_Toggle (2)_Back");
    }
}
