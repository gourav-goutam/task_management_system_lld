package tasksystem;

import tasksystem.display.DisplayOutput;
import tasksystem.exceptions.InvalidModeException;
import tasksystem.mode.FileMode;
import tasksystem.mode.InteractiveMode;

public class Main {
    public static void main(String[] args) {

        if (isInteractiveMode(args)) {
            new InteractiveMode().process();
        } else if (isFileInputMode(args)) {
            new FileMode(args[0]).process();
        } else {
            throw new InvalidModeException();
        }

        DisplayOutput displayOutput = new DisplayOutput();
        displayOutput.displayTasksByUsers();
        displayOutput.displaySprintStatus();

    }
    private static boolean isFileInputMode(final String[] args) {
        return args.length == 1;
    }

    private static boolean isInteractiveMode(final String[] args) {
        return args.length == 0;
    }

}
