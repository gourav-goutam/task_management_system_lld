package tasksystem.mode;

import tasksystem.Commands.Command;
import tasksystem.Commands.CommandExecutor;
import tasksystem.exceptions.InvalidCommandException;

import java.io.IOException;

public abstract class Mode {
    public abstract void process() throws IOException;

    protected void processCommand(final Command command) {
        final CommandExecutor commandExecutor = new CommandExecutor();
        if (commandExecutor.validate(command.getCommand())) {
            commandExecutor.execute(command.getCommand());
        } else {
            throw new InvalidCommandException();
        }
    }

}
