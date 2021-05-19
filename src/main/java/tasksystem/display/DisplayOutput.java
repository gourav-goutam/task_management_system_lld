package tasksystem.display;

import tasksystem.modals.Sprint;
import tasksystem.modals.SubTrack;
import tasksystem.modals.Task;
import tasksystem.modals.types.IssueType;
import tasksystem.services.SprintService;
import tasksystem.services.SubtrackService;
import tasksystem.services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DisplayOutput {

    private void displayAssigneeTasks(String userName, ArrayList<Task> tasks){
            System.out.println("User => "+userName);
            Map<String, ArrayList<Task>> groupByType = new HashMap<>();
            for(Task task : tasks){
                String type = task.getType().getClass().getSimpleName();
                if(!groupByType.containsKey(type))
                    groupByType.put(type, new ArrayList<>());
                groupByType.get(type).add(task);
            }
            groupByType.forEach((issueType, tasks1) -> {
                System.out.println("\tTask Type => "+ issueType);
                tasks1.forEach(task -> {
                    System.out.println("\t\tTitle => "+task.getTitle());
                    System.out.println("\t\tSprint => "+task.getSprint());

                    if(issueType.equalsIgnoreCase("story")){
                        SubtrackService subtrackService = SubtrackService.getInstance();
                        HashMap<String, SubTrack> subtracks = subtrackService.getSubtracks();
                        ArrayList<String> tracks = new ArrayList<>();
                        for (Map.Entry<String, SubTrack> entry : subtracks.entrySet()){
                            try {
                                if(entry.getValue().getTask().getTitle().equalsIgnoreCase(task.getTitle())){
                                    tracks.add("\t\t\t\t"+entry.getValue().getTitle());
                                }
                            } catch (Exception e) {}
                        }
                        if(!tracks.isEmpty()){
                            System.out.println("\t\tSubTrack : ");
                            for(String track : tracks)
                                System.out.println(track);
                        }
                    }
                });
                System.out.println();
            });
        }

    public void displayTasksByUsers(){
        UserService userService = UserService.getInstance();
        HashMap<String, ArrayList<Task>> map = userService.getUsers();
        for(Map.Entry<String, ArrayList<Task>> entry : map.entrySet()){
            displayAssigneeTasks(entry.getKey(), entry.getValue());
        }
    }

    public void displaySprintStatus(){
        SprintService sprintService = SprintService.getInstance();
        HashMap<String, Sprint> map = sprintService.getSprints();
        ArrayList<String> delayedTask = new ArrayList<>();
        ArrayList<String> onTrackTasks = new ArrayList<>();

        for(Map.Entry<String, Sprint> entry : map.entrySet()){
            System.out.println("Sprint Title => "+entry.getKey());
            for(Task task : entry.getValue().getTasks()){
                if(task.getDate().isBefore(LocalDate.now())) //Comparing if due date is crossed or not
                    delayedTask.add(task.getTitle());
                else
                    onTrackTasks.add(task.getTitle());
            }
            if(!onTrackTasks.isEmpty()){
                System.out.println("\tOn Track Tasks : ");
                for(String task : onTrackTasks)
                    System.out.println("\t\t"+task);
            }
            System.out.println();
            if(!delayedTask.isEmpty()){
                System.out.println("\tDelayed Tasks : ");
                for(String task : delayedTask)
                    System.out.println("\t\t"+task);
            }
        }
    }
}
