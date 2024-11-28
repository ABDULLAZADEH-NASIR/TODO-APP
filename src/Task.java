import java.util.Objects;

public class Task {
    private  int ID;
    private String taskName;
    private String dueDate;
    private Priority priority;
    private Status status;
    public User user;

    public Task(){}

    public Task(String taskName, String dueDate, Priority priority, Status status) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(ID, task.ID) && Objects.equals(taskName, task.taskName) &&
                Objects.equals(dueDate, task.dueDate) && priority == task.priority
                && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, taskName, dueDate, priority, status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "ID='" + ID + '\'' +
                ", taskName='" + taskName + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
