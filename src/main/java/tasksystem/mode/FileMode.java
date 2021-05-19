package tasksystem.mode;

import tasksystem.Commands.Command;

import java.io.*;

public class FileMode extends Mode{

    String fileName;

    public FileMode(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void process()  {
        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            return;
        }
        try {
            String input = reader.readLine().trim();
            while (input != null) {
                final Command command = new Command(input);
                if(!input.equalsIgnoreCase(""))
                    processCommand(command);
                input = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
