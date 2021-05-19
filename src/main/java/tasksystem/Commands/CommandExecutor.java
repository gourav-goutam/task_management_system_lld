package tasksystem.Commands;

import tasksystem.services.TaskService;
import tasksystem.services.TaskSystemService;

public class CommandExecutor {

    public boolean validate(String command){
        if(command.split("#").length == 7 || command.split("#").length == 8 || command.split("#").length == 3){
            return true;
        }
        return false;
    }
    public  void execute(String command){
        TaskSystemService taskSystemService = new TaskSystemService();
        taskSystemService.create(command);
    }

}
