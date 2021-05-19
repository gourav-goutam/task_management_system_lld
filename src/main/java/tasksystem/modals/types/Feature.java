package tasksystem.modals.types;

import tasksystem.datastore.DataStore;
import tasksystem.exceptions.InvalidFeatureImpactException;
import tasksystem.exceptions.InvalidStatusForFeatureException;

public class Feature implements IssueType{
    private String summary;
    private String impact;
    private String status;

    @Override
    public void attributes(String attr,String status) {
        this.summary = attr.split(",")[0];
        if(DataStore.featureImpact.contains(attr.split(",")[1].trim().toLowerCase()))
            this.impact = impact;
        else
            throw new InvalidFeatureImpactException();
        if(DataStore.featureStatus.contains(status.toLowerCase()))
            this.status = status;
        else
            throw new InvalidStatusForFeatureException();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        if(DataStore.featureImpact.contains(impact.toLowerCase()))
            this.impact = impact;
        else
            throw new InvalidFeatureImpactException();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if(DataStore.featureStatus.contains(status.toLowerCase()))
            this.status = status;
        else
            throw new InvalidStatusForFeatureException();
    }
}
