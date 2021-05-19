package tasksystem.services;

import tasksystem.modals.Sprint;
import tasksystem.modals.Task;

public class TaskSystemService {
    TaskService taskService = TaskService.getInstance();
    SprintService sprintService = SprintService.getInstance();
    SubtrackService subtrackService = SubtrackService.getInstance();

    public Task createTask(String command){
        return taskService.createTask(command);
    }
    public void createSprint(String command,Sprint sprint){
        sprintService.createSprint(command, sprint);
    }

    public void createSubtrack(String command){
        subtrackService.createSubtrack(command);
    }

    public void create(String command) {
        String[] commandsArgs = command.split("#");

        if(command.split("#").length == 8 || command.split("#").length == 7){
            //create task and sprint and add task to sprint
            Task task = createTask(command);
            if(command.split("#").length == 8){
                String sprintName = command.split("#")[7].trim();
                Sprint sprint;
                if(!sprintService.getSprints().containsKey(sprintName)){
                    sprint = new Sprint(sprintName);
                    createSprint(sprintName, sprint);
                }else
                    sprint = sprintService.getSprints().get(sprintName);
                sprint.addTask(task);
            }
        }else {
            //create subtrack
            createSubtrack(command);
        }
    }
}
