package tasksystem.modals.types;

public class IssueTypeFactory {

    public IssueType getIssueType(String issueType){
        if(issueType == null){
            return null;
        }
        if(issueType.equalsIgnoreCase("bug")){
            return new Bug();

        } else if(issueType.equalsIgnoreCase("story")){
            return new Story();

        } else if(issueType.equalsIgnoreCase("feature")){
            return new Feature();
        }

        return null;
    }
}
