import java.util.regex.Pattern;

public class Validation {
    public boolean validationMail(String mail){
         String regex =  "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (Pattern.matches(regex,mail )){
            return  true;
        } else {
            return false;
        }
    }

    public  boolean validationName(String name){
        String regex = "^[a-zA-Z]{1,8}$";
        if (name.matches(regex)) {
            return  true;
        } else {
            return false;
        }
    }

    public  boolean validationSurname(String surname){
        String regex = "^[a-zA-Z]+$";
        if (surname.matches(regex)) {
            return  true;
        } else {
            return false;
        }
    }

    public  boolean validationPassword(String password){
        String regex =  "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$";
        if (password.matches(regex)) {
            return  true;
        } else {
              return false;
        }
    }
    public  boolean validationTaskName(String taskName){
        if(taskName.isEmpty()){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean validationDueDate(String dueDate){
        String regex = "^(\\d{4})\\.(0[1-9]|1[0-2])\\.(0[1-9]|[12][0-9]|3[01])$";
        return Pattern.matches(regex, dueDate);
    }

}
