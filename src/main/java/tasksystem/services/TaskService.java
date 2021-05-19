package tasksystem.services;

import tasksystem.datastore.DataStore;
import tasksystem.modals.Task;
import tasksystem.modals.types.IssueType;
import tasksystem.modals.types.IssueTypeFactory;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class TaskService {

    private static TaskService taskService = new TaskService();
    private TaskService(){}
    public static TaskService getInstance(){ return taskService;}

    public Task createTask(String command){
        String[] commandsArgs = command.split("#");
        Arrays.parallelSetAll(commandsArgs, (i) -> commandsArgs[i].trim());
        IssueTypeFactory issueTypeFactory = new IssueTypeFactory();
        IssueType issueType = issueTypeFactory.getIssueType(commandsArgs[5]);
        issueType.attributes(commandsArgs[6], commandsArgs[3]);
        Task task;
        if(commandsArgs.length == 7)
            task = new Task(commandsArgs[0], commandsArgs[1], commandsArgs[2],commandsArgs[3], LocalDate.parse(commandsArgs[4]), issueType, "");
        else
            task = new Task(commandsArgs[0], commandsArgs[1], commandsArgs[2],commandsArgs[3], LocalDate.parse(commandsArgs[4]), issueType, commandsArgs[7]);

        if(!DataStore.taskMap.containsKey(commandsArgs[0]))
            DataStore.taskMap.put(commandsArgs[0], task);
        createUser(commandsArgs[2], task);

        return task;
    }

    private void createUser(String userName, Task task){
        UserService userService = UserService.getInstance();
        userService.createUser(userName, task);
    }

    public void removeTask(Task task){
        DataStore.taskMap.remove(task.getTitle());
    }

    public HashMap<String, Task> getTasks() { return DataStore.taskMap;}
}
