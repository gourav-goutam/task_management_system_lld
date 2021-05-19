package tasksystem.modals.types;

import tasksystem.datastore.DataStore;
import tasksystem.exceptions.InvalidStatusForBugException;

public class Bug implements IssueType{

    //Open, In progress, Fixed
    private String priority;
    private String status;

    @Override
    public void attributes(String attr, String status) {
        this.priority = attr;
        if(DataStore.bugStatus.contains(status.toLowerCase()))
            this.status = status;
        else
            throw new InvalidStatusForBugException();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(DataStore.bugStatus.contains(status.toLowerCase()))
            this.status = status;
        else
            throw new InvalidStatusForBugException();
    }
}
