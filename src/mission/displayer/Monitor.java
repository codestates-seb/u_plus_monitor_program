package mission.displayer;

import java.util.Scanner;

public class Monitor {
    private boolean isConnected = false;
    private final int HORIZONTAL;
    private final int VERTICAL;
    protected Scanner scanner = new Scanner(System.in);

    public Monitor(int HORIZONTAL, int VERTICAL) {
        this.HORIZONTAL = HORIZONTAL;
        this.VERTICAL = VERTICAL;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void connect() {
        if (!isConnected) {
            isConnected = true;
            printDisplay("Standard monitor is connected.");
        }
        else {
            printDisplay("Already connected.");
        }
    }

    public void printDisplay(String content) {

        if (isConnected) {
            if (!isValidLength(content)) content = "Invalid content length.";
            System.out.println("-".repeat(HORIZONTAL));
            System.out.printf("%s\n", composeScreen(content));
            System.out.println("-".repeat(HORIZONTAL));
        }
        else {
            System.out.println("No signal");
        }
    }

    private boolean isValidLength(String content) {
        return content.length() <= (HORIZONTAL - 4) * VERTICAL;
    }

    private String composeScreen(String str) {

        StringBuilder stringBuilder = new StringBuilder(str.charAt(0) + "");

        for (int i = 1; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if (i % (HORIZONTAL - 1) == 0) stringBuilder.append("\n");
        }

        stringBuilder.append("\n".repeat(VERTICAL - str.length() / (HORIZONTAL - 1)));

        return stringBuilder.toString();
    }
}
