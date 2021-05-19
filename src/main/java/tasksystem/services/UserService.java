package tasksystem.services;

import tasksystem.datastore.DataStore;
import tasksystem.modals.Task;
import tasksystem.modals.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UserService {

    private static UserService userService = new UserService();
    private UserService(){}
    public static UserService getInstance(){ return userService;}

    public HashMap<String, ArrayList<Task>> getUsers(){
        return  DataStore.userMap;
    }
    public void createUser(String userName, Task task){
        User user = new User(userName);
        if(!DataStore.userMap.containsKey(userName))
            DataStore.userMap.put(userName, new ArrayList<>());
        DataStore.userMap.get(userName).add(task);
    }
}
