package tasksystem.modals;

import tasksystem.datastore.DataStore;
import tasksystem.exceptions.InvalidStatusForSubTrackException;

public class SubTrack {

    private String title;
    private String status;
    private Task task;

    public SubTrack(String title, String status, Task task){
        this.title = title;
        this.status = status;
        this.task = task;
    }
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(DataStore.subtrackStatus.contains(status))
            this.status = status;
        else
            throw new InvalidStatusForSubTrackException();
    }


}
