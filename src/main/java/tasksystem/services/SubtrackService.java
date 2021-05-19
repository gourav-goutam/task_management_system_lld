package tasksystem.services;

import tasksystem.datastore.DataStore;
import tasksystem.modals.SubTrack;

import java.util.HashMap;

public class SubtrackService {

    private static SubtrackService subtrackService = new SubtrackService();
    private SubtrackService(){}
    public static SubtrackService getInstance(){ return subtrackService;}
    public void createSubtrack(String command){
        String[] commandsArgs = command.split("#");
        TaskService taskService = TaskService.getInstance();
        SubTrack subTrack = new SubTrack(commandsArgs[0].trim(), commandsArgs[1].trim(), DataStore.taskMap.get(commandsArgs[2].trim()));
        if(!DataStore.subtrackMap.containsKey(subTrack.getTitle()))
            DataStore.subtrackMap.put(subTrack.getTitle(), subTrack);
    }

    public HashMap<String, SubTrack> getSubtracks(){
        return DataStore.subtrackMap;
    }
}
