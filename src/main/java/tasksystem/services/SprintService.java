package tasksystem.services;

import tasksystem.datastore.DataStore;
import tasksystem.modals.Sprint;
import tasksystem.modals.Task;

import java.util.HashMap;

public class SprintService {

    private static SprintService sprintService = new SprintService();
    private SprintService(){}
    public static SprintService getInstance(){ return sprintService;}


    public void createSprint(String sprintName, Sprint sprint) {
        if(!DataStore.sprintMap.containsKey(sprintName)){
            DataStore.sprintMap.put(sprint.getName(), sprint);
        }
    }

    public void removeTaskFromSprint(Sprint sprint, Task task){
        sprint.removeTask(task);
    }
    public void addTaskToSprint(Sprint sprint, Task task){
        sprint.addTask(task);
    }
    public HashMap<String, Sprint> getSprints(){
        return DataStore.sprintMap;
    }
}
