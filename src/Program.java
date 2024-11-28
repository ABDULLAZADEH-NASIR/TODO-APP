import java.util.Scanner;

public class Program {
    static Scanner scanner = new Scanner(System.in);
    public static void todoApp() {
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        while (true) {
          showMenu();
            int num = scanner.nextInt();
            try {
                switch (num) {
                    case 1:
                        userService.create();
                        System.out.println("User registered");
                        break;
                    case 2:
                        userService.login();
                        System.out.println("Logged is succesfully");
                        break;
                    case 3:
                        userService.changePassword();
                        break;
                    case 4:
                        taskService.addTodo();
                        System.out.println("Task added");
                        break;
                    case 5:
                        taskService.viewTODO();
                        break;
                    case 6:
                           taskService.updateStatus();
                        System.out.println("Status uptated");
                        break;
                    case 7:
                        taskService.deleteTask();
                        System.out.println("Task deleted");
                        break;
                    case 8:
                        userService.logOut();
                        System.out.println("Log out succesfully");
                        break;
                    case 9:
                        System.exit(0);
                    default:
                        System.out.println("Please enter only a number between 1 and 9.");
                        break;
                }
            }
            catch (Exception e) {
                  e.printStackTrace();
            }
        }
    }

    public static void showMenu(){
        System.out.println();
        System.out.println("Choose one of the numbers");
        System.out.println("1.Create an Account");
        System.out.println("2.Login");
        System.out.println("3.Change Password");
        System.out.println("4.Add TODO");
        System.out.println("5.View TODOs");
        System.out.println("6.Update status");
        System.out.println("7.Delete task");
        System.out.println("8.Logout");
        System.out.println("9.Exit");
        System.out.println();
    }
}

