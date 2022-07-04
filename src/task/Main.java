package task.pkg1;

/*
code attribution
adapted from https://stackoverflow.com/questions/637980/if-else-and-if-elseif
sharptooth
https://stackoverflow.com/users/57428/sharptooth
 */
import task.TaskReport;
import task.pkg1.Login;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Tevessan Naidoo
 */
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Login loginMethod = new Login();
        Task2 taskClass = new Task2();
        TaskReport report = new TaskReport();
        String firstName;
        

        String lastName;

        System.out.println("\nPlease enter your First Name: ");

        firstName = input.next();

        System.out.println("\nPlease enter your Last Name: ");

        lastName = input.next();

        System.out.println("\nPlease enter username: ");

        String username = input.next();

        // The if statement below checks if the username correct or incorrect and returns an appropiate response.
        if (loginMethod.checkUserName(username) == true) {

            System.out.println("\nusername is correct");

            System.out.println("\nPlease enter password");

            String password = input.next();

            // The if statement below checks if the password correct or incorrect and returns an appropiate response.
            if (loginMethod.checkPasswordComplexity(password) == true) {

                System.out.println("\npassword is correct");

                System.out.println(loginMethod.registerUser(username, password));

                System.out.println("\nPlease enter your username to sign in: ");

                String userNamecheck = input.next();

                System.out.println("\nPlease enter your password to sign in: ");

                String passWordcheck = input.next();

                // The if statement below checks if the given username and password are successful when loggin in.
                if (loginMethod.loginUser(username, password, userNamecheck, passWordcheck) == true) {

                    
                    System.out.println(loginMethod.returnLoginStatus("success"));

                    System.out.println("\nWelcome " + firstName + " " + lastName + ", it is great to see you.");
                    JOptionPane.showMessageDialog(null, "Welcome to EasyKhanBan");

                    for (int i = 0; i > -1; i++) {
                         int task = Integer.parseInt(JOptionPane.showInputDialog("Choose one of the following task:\n 1: Add Task\n 2: Show Report\n 3: Quit "));
        
                            if (task == 1) {
                                  int taskNumber = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to enter:"));
                                  //initilizing arrays
                                    String [] developer = new String[taskNumber];
                                    String [] description = new String[taskNumber];
                                    String [] tNames = new String[taskNumber];
                                    String [] tId = new String[taskNumber];
                                    int [] tDuration = new int[taskNumber];
                                    String [] tStatus = new String[taskNumber];
                                 for (int k = 0; k < taskNumber; k++) {
                                String taskName = JOptionPane.showInputDialog("Please give the task name: ");
                                 tNames[k] = taskName;

                                 //showing the task number
                                JOptionPane.showMessageDialog(null, "Task number: " + k);

                                String taskDescription = JOptionPane.showInputDialog("Please give the task Description");
                                description[k] = taskDescription;

                                while (taskClass.taskDescription(taskDescription) == false) {
                                    taskDescription = JOptionPane.showInputDialog("Task descriptions have to be less than 50 characters,\n"
                                            + "Please give the task Description again: ");
                                }
                                String nameSurnameDetails = JOptionPane.showInputDialog("Please provide first and last name of the developer: ");
                                developer[k] = nameSurnameDetails;

                                int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Please give the task duration: "));
                                taskClass.totalHours(taskDuration);
                                tDuration[k] = taskDuration;

                                JOptionPane.showMessageDialog(null, "Task ID: " + taskClass.taskID(taskName, k, nameSurnameDetails));
                                tId[k] = taskClass.taskID(taskName, k, nameSurnameDetails);

                                int status = Integer.parseInt(JOptionPane.showInputDialog("Choose the number to give status to developer:\n 1: ToDo \n 2: Done \n 3: Doing "));
                                if (status == 1) {
                                    tStatus[k] = "Todo";
                                    JOptionPane.showMessageDialog(null, taskClass.allTaskDetails("ToDo", nameSurnameDetails, k, taskName, taskDescription, taskClass.taskID(taskName, k, nameSurnameDetails), taskDuration));
                                    if (k == taskNumber - 1) {
                                        JOptionPane.showMessageDialog(null, "Total duration: " + taskClass.totalHours(0) + "hours");
                                       report.setReport(developer, tNames, tId, tDuration, tStatus, description);
                                    }
                                } else if (status == 2) {
                                     tStatus[k] = "Done";
                                    JOptionPane.showMessageDialog(null, taskClass.allTaskDetails("Done", nameSurnameDetails, k, taskName, taskDescription, taskClass.taskID(taskName, k, nameSurnameDetails), taskDuration));
                                    if (k == taskNumber - 1) {

                                        JOptionPane.showMessageDialog(null, "Total duration: " + taskClass.totalHours(0) + "hours");
                                       report.setReport(developer, tNames, tId, tDuration, tStatus, description);
                                    }
                                } else if (status == 3) {
                                     tStatus[k] = "Doing";
                                    JOptionPane.showMessageDialog(null, taskClass.allTaskDetails("Doing", nameSurnameDetails, k, taskName, taskDescription, taskClass.taskID(taskName, k, nameSurnameDetails), taskDuration));
                                    if (k == taskNumber - 1) {

                                        JOptionPane.showMessageDialog(null, "Total duration: " + taskClass.totalHours(0) + "hours");
                                       report.setReport(developer, tNames, tId, tDuration, tStatus, description);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Wrong Number");
                                }

                                 }
                            } else if (task == 2) {
                                 int decision = Integer.parseInt(JOptionPane.showInputDialog(
                                        "Please choose the number: "+
                                        "\n\t 1: Display the developer " +
                                        "\n\t 2: Display the developer with done status" +
                                        "\n\t 3: Display Developer and Duration with long time." +
                                        "\n\t 4: Search tasks " +
                                        "\n\t 5: Tasks assigned to Developer " +
                                        "\n\t 6: Delete Task " +
                                        "\n\t 7: Report Display"));
                                 if(decision == 1){
                                      JOptionPane.showMessageDialog(null, "All Developers name: "
                                        + report.showDevelopers());
                                 }else if(decision == 2){
                                     JOptionPane.showMessageDialog(null, "All Developers name with done status: "
                                        + report.displayDevelopersWithDone());
                                 }else if(decision == 3){
                                     JOptionPane.showMessageDialog(null, "Longest Duration: "
                                        + report.longestDuration());
                                 }else if(decision == 4){
                                      String taName = JOptionPane.showInputDialog("Give task name: ");
                                     JOptionPane.showMessageDialog(null, "Developers: "
                                        + report.taskDevStatus(taName));
                                 }else if(decision == 5){
                                     String DName = JOptionPane.showInputDialog("Give the name of the Developer to see their task and status: ");
                                JOptionPane.showMessageDialog(null,report.getdevNameTaskStatus(DName));
                                 }else if(decision == 6){
                                     String delTask = JOptionPane.showInputDialog("Task Name to delete: ");
                                JOptionPane.showMessageDialog(null,report.delTask(delTask));
                                 }else if(decision == 7){
                                     JOptionPane.showMessageDialog(null,report.showTask());
                                 }else{
                                     JOptionPane.showInputDialog("Wrong number");
                                 }
                            } else if (task == 3) {
                                JOptionPane.showMessageDialog(null, "Program has ended");
                                i= -3;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Incorrect number has been choosen");
                                continue;
                            }   
                        }
                    }
                    
              else {
                    // the below statement outputs the response when the username and password are incorrectly entered.

                    System.out.println(loginMethod.returnLoginStatus(""));
                }
        
            } else {
                // the below statement outputs two response depending if the username is incorrect or password is incorrecet.

                System.out.println(loginMethod.registerUser(username, password));
            }

        } else {
            // the below statement outputs a response when the username is entered  incorrectly. 

            String password = "";

            System.out.println(loginMethod.registerUser(username, password));
        }
    }

}
