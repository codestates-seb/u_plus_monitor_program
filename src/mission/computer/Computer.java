package mission.computer;

import mission.displayer.Displayer;

import java.util.Scanner;

public class Computer {
    private Displayer monitor;
    private Scanner scanner = new Scanner(System.in);

    public Computer(Displayer monitor) {
        this.monitor = monitor;
    }

    public void operate() {

        String input;

        while (true) {

            System.out.println("(1)_Connect (2)_Print (3)_Setting (4)_Terminate");

            input = scanner.nextLine();
            String inputContent;

            switch (input) {
                case "1":
                    monitor.connect();
                    break;
                case "2":
                    inputContent = monitor.isConnected() ?
                    inputStr(true) :
                    inputStr(false);
                    monitor.printDisplay(inputContent);
                    break;
                case "3":
                    monitor.configureSetting();
                    break;
                case "4":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong command inserted.");
            }
        }
    }

    private String inputStr(boolean isConnected) {
        if (!isConnected) return "";
        System.out.print("Insert content : ");
        return scanner.nextLine();
    }
}
