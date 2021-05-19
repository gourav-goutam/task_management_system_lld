package tasksystem.modals;

import java.util.ArrayList;
import java.util.List;

public class Sprint {

    ArrayList<Task> tasks = new ArrayList<>();
    private String name;

    public Sprint(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task){
        tasks.add(task);
    }
    public boolean removeTask(Task task){
        return tasks.remove(task);
    }
    public ArrayList<Task> getTasks(){
        return tasks;
    }
}
