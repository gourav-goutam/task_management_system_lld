package tasksystem.modals.types;

import tasksystem.datastore.DataStore;
import tasksystem.exceptions.InvalidStatusForStoryException;
import tasksystem.modals.SubTrack;

import java.util.ArrayList;
import java.util.List;

public class Story implements IssueType{
    private String summary;
    private String status;
    private List<SubTrack> subtracks = new ArrayList<>();

    @Override
    public void attributes(String attr,String status) {
        this.summary = attr;
        if(DataStore.storyStatus.contains(status.toLowerCase()))
            this.status = status;
        else
            throw new InvalidStatusForStoryException();
    }

    public boolean removeSubtrack(SubTrack subtrack) {
        return subtracks.remove(subtrack);
    }

    public void addSubtracks(SubTrack subtrack) {
        subtracks.add(subtrack);
    }

    public List<SubTrack> getSubtracks(){
        return subtracks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(DataStore.storyStatus.contains(status.toLowerCase()))
            this.status = status;
        else
            throw new InvalidStatusForStoryException();
    }
}
