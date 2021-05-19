package tasksystem.modals;

import tasksystem.modals.types.IssueType;

import java.time.LocalDate;
import java.util.Objects;

public class Task {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return title.equals(task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    private String title;
    private String Creator;
    private String assignee;
    private String status;
    private LocalDate date;
    private IssueType type;
    private String sprint;

    public Task(String title, String creator, String assignee, String status, LocalDate date, IssueType type, String sprint){
        this.title = title;
        this.Creator = creator;
        this.assignee = assignee;
        this.status = status;
        this.date = date;
        this.type = type;
        this.sprint = sprint;
    }


    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getSprint() {
        return sprint;
    }

    public void setSprint(String sprint) {
        this.sprint = sprint;
    }

    public String getCreator() {
        return Creator;
    }

    public void setCreator(String creator) {
        Creator = creator;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IssueType getType() {
        return type;
    }

    public void setType(IssueType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



}
