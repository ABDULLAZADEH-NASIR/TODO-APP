import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserService extends Storage{
    static  Scanner scanner = new Scanner(System.in);
    public void create(){
        User user = new User();
        Validation validation = new Validation();
        System.out.println("Enter your name: ");
        String name=scanner.next();

        if (!validation.validationName(name)) {
            throw new RuntimeException("Invalid name");
        }
        user.setName(name);

        System.out.println("Enter your surname");
        String  surname = scanner.next();
        if (!validation.validationSurname(surname)) {
            throw  new RuntimeException("Invalid Surname");
        }
        user.setSurName(surname);

        System.out.println("Enter your password");
        String password=scanner.next();
        if(!validation.validationPassword(password)){
            throw  new RuntimeException("Invalid password");
        }
        user.setPassword(password);

        System.out.println("Enter your mail: ");
        String mail = scanner.next();
        if (!validation.validationMail(mail)){
            throw new RuntimeException("Invalid mail");
        }
        user.setMail(mail);
        users.add(user);
    }

    public  void changePassword(){
        TaskService.checkUser();
        Validation validation=new Validation();
        System.out.println("Enter the mail address the user whose password you want to change");
       String cahengedMail=scanner.next();
       for(User u:users) {
           if (u.getMail().equals(cahengedMail)) {
               System.out.println("Enter  old password");
               String oldPassword = scanner.next();
               if (oldPassword.equals(u.getPassword())) {
                   System.out.println("Enter new password");
                   String newPassword = scanner.next();
                   if (validation.validationPassword(newPassword)) {
                       u.setPassword(newPassword);
                       System.out.println("Password changed");
                       return;
                   } else {
                       throw new RuntimeException("Invalid new password");
                   }
               } else {
                   throw new RuntimeException("Invalid old password");
               }
           }
       }
    }

    public  void login(){
        System.out.println("Enter mail");
        String mail=scanner.next();
        System.out.println("Enter password");
        String password=scanner.next();
        boolean search=false;

        for (User u:users){
            if((u.getMail().equals(mail) && u.getPassword().equals(password))){
                currentuser=u;
                search=true;
            }
        }
        if(search==false){
            throw new RuntimeException("User not found");
        }
    }
    public  void logOut(){
        TaskService.checkUser();
        currentuser=null;
    }
}












