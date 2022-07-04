package task.pkg1;

/*
code attribution
adapted from https://stackoverflow.com/questions/637980/if-else-and-if-elseif
sharptooth
https://stackoverflow.com/users/57428/sharptooth
adapted from https://coderanch.com/t/449271/java/java-regular-expression-giving-stack
steve labar
https://coderanch.com/u/181308/steve-labar
 */


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tevessan Naidoo
 */
public class Login 

    // This method checks the username.
    public boolean checkUserName(String storeName) {

        if (storeName.contains("_") && storeName.length() <= 5) {

            return true;

        } else {
            return false;
        }
    }
    // This method checks password complexity.
    public boolean checkPasswordComplexity(String password) {


        String allTheCharacters = "^(?=.*[a-z])(?=."
                
                + "*[A-Z])(?=.*\\d)"
                
                + "(?=.*[-+_!@#$%^&*., ?]).+$";

        Pattern p = Pattern.compile(allTheCharacters);

        if (password.length() < 8) {
            
            return false;
            
        }

        Matcher m = p.matcher(password);

        if (m.matches()) {
            
            return true;
            
        } else {
            
            return false;

        }
    }
    
    //This method gives an appropriate response depending on if the password is incorrect or if the username is incorrect and when both the password and username are correct.
    public String registerUser(String Name, String Password) {
        
        if (checkUserName(Name) == false && checkPasswordComplexity(Password) == false) {
            
            return "\nUser name is not correctly formatted,Please ensure that your username contain an underscore and is no more than 5 characters in length.";
            
        } else if (checkUserName(Name) == true && checkPasswordComplexity(Password) == false) {
            
            return "\nPassword is not correctly formatted, Please ensure that the pass word contains atleast 8 character, 1 capital letter and special character.";
            

        } else {
            
            return "\nthe two above conditions have met and the user has been registered successfully.";
            
        }

    }

        // This method checks the username and password and returns true or false if the username and password is correct or incorrect.
    public boolean loginUser(String userName, String passWord, String userNamecheck, String passWordcheck) {
        
        if (userName.equals(userNamecheck) && passWord.equals(passWordcheck)) {
            
            return true;
            
        } else {
            
            return false;
            
        }

    }
    
    // This method returns a message if the login is sucessfull or unsuceessful.
    public String returnLoginStatus(String success) {
        
        if (success.equals("success")) {
            
            return "\nSuccessful login";
            
        } else {
            
            return "\nUnsuccessful login";
            
        }
    }

    public String returnLoginStatus(String user_first_name, String user_last_name, String name, String chsecke99, String name0, String chsecke990) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
