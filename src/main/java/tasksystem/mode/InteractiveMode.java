package tasksystem.mode;

import tasksystem.Commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{
    @Override
    public void process() {
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                final Command command = new Command(reader.readLine());
                processCommand(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
