package tasksystem.datastore;

import tasksystem.modals.Sprint;
import tasksystem.modals.SubTrack;
import tasksystem.modals.Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public interface DataStore {

    // object storage ds
    HashMap<String, Task> taskMap = new HashMap<>();
    HashMap<String, Sprint> sprintMap = new HashMap<>();
    HashMap<String, SubTrack> subtrackMap = new HashMap<>();
    HashMap<String, ArrayList<Task>> userMap = new HashMap<>();

    // value check static ds
    List<String> bugStatus = new ArrayList<>(Arrays.asList("open", "in progress", "fixed"));
    List<String> storyStatus = new ArrayList<>(Arrays.asList("open", "in progress", "completed"));
    List<String> subtrackStatus = new ArrayList<>(Arrays.asList("open", "in progress", "completed"));
    List<String> featureStatus = new ArrayList<>(Arrays.asList("open", "in progress", "testing", "deployed"));

    List<String> featureImpact = new ArrayList<>(Arrays.asList("low", "moderate", "high"));
    List<String> bugPriority = new ArrayList<>(Arrays.asList("P0", "P1", "P2"));
}
