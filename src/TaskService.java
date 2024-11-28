import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskService extends Storage{
    static Scanner scanner=new Scanner(System.in);
    private static  int ID=1;
    public void addTodo(){
        checkUser();
        Task task=new Task();
        Validation validation=new Validation();
        System.out.println("Enter the name of the TODO task");
        String taskName= scanner.next();
        System.out.println("Enter priority (Low, Medium, High)");
        String taskPriority= scanner.next();
        System.out.println("Enter the due date for the task :(e.g., YYYY.MM.DD)");
        String dueDate=scanner.next();

        if(!validation.validationTaskName(taskName)){
            throw new RuntimeException("The name Task is empty.");
        }
        task.setTaskName(taskName);

        if(taskPriority.equalsIgnoreCase("Low")){
            task.setPriority(Priority.Low);
        }
        else if (taskPriority.equalsIgnoreCase("Medium")){
            task.setPriority(Priority.Medium);
        } else if (taskPriority.equalsIgnoreCase("High")){
            task.setPriority(Priority.High);
        }
        else {
            throw new RuntimeException("Enter one of the three priorities");
        }


        if(!validation.validationDueDate(dueDate)){
            throw new RuntimeException("The due date is not in the correct format.");
        }
        task.setDueDate(dueDate);

        task.setStatus(Status.PENDING);
        task.user=currentuser;
        tasks.add(task);
        task.setID(ID++);

    }
    public  void  viewTODO(){
        checkUser();
        boolean isEmpty=true;
        for(Task t:tasks){
            if(currentuser.equals(t.getUser())){
                System.out.println(t.toString());
                isEmpty=false;
            }
        }
        if (isEmpty){
            System.out.println("You don't have a task...");
        }
    }
    public void updateStatus() {
        viewTODO();
        System.out.println("Enter the task id whose status you want to update");
        boolean searchId = false;
        int selectedId = scanner.nextInt();
        for (Task t : tasks) {
            if (selectedId == t.getID()) {
                t.setStatus(Status.IN_PROGRESS);
                searchId = true;
            }
        }
        if (!searchId) {
            throw new RuntimeException("task id is not found");
        }
    }

    public void deleteTask(){
        checkUser();
        Task task=new Task();
        Validation validation=new Validation();
        for (Task t:tasks){
            if(t.getUser()==currentuser){
                System.out.println(t.toString());
            }
        }
        boolean searchID=false;
        System.out.println("Enter the ID of the task you want to delete.");
        int taskID= scanner.nextInt();
        for (Task t:tasks){
            if(taskID==t.getID()){
                tasks.remove(t);
                searchID=true;
            }
        }
        if (searchID==false){
            throw new RuntimeException("The task id to be deleted was not found");
        }
    }

    public static void checkUser(){
        if(UserService.currentuser==null){
            throw new RuntimeException("If you are not registered, please register. " +
                    "If you already have an account, please select Login.");
        }
    }
}
