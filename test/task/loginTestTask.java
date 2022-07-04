/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

import org.junit.Test;
import task.pkg1.Login;
import task.pkg1.Task2;
import static java.lang.Double.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 * @author Naidoo
 */
public class loginTestTask 
    Login input = new Login();
    Task2 taskInput = new Task2();

    @Test
    public void testRegisterUserKyle() {
        String expected = "\nUser name is not correctly formatted,Please ensure that your username contain an underscore and is no more than 5 characters in length.";
        String actual = input.registerUser("Kyle!!!!!!!", "sdkfAF");
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswrodComplexity() {
        String password = "Ch&&sec@ke99";
        String expected = "Password successfully captured.";
        String actual;
        if (input.checkPasswordComplexity(password) == true) {
            actual = "Password successfully captured.";
        } else {
            actual = "";
        }

        assertEquals(expected, actual);
    }

    //test data password is "passwrod"
    @Test
    public void checkPasswordComplexitypassword() {
        String expected = "\nPassword is not correctly formatted, Please ensure that the pass word contains atleast 8 character, 1 capital letter and special character.";
        String actual = input.registerUser("Kyl_1", "password");
        assertEquals(expected, actual);
    }

    //test data Login is Successful 
    @Test
    public void returnLoginStatustrue() {
        boolean expected = true;
        boolean actual;
        if (input.loginUser("kyl_1", "Ch&&sec@ke99", "kyl_1", "Ch&&sec@ke99") == true) {
            actual = true;
        } else {
            actual = false;
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testPasswordComplexity() {
        boolean expected = false;
        boolean actual;
        if (input.checkPasswordComplexity("password") == true) {
            actual = true;
        } else {
            actual = false;
        }
        assertEquals(expected, actual);
    }
    //task 1
    String taskName = "Login Feature";
    int taskNumber = 0;
    String taskDescription = "Create Login to authenticate users";
    String developerDetails = "Robyn";
    int duration = 8;
    String taskStatus = "To Do";

    //task 2
    String taskName2 = "Add Task Feature";
    int taskNumber2 = 1;
    String taskDescription2 = "Create Add Task feature to add task users";
    String developerDetails2 = "Mike";
    int duration2 = 10;
    String taskStatus2 = "Doing";
 @Test
    public void taskId() {
        String expected = "LO:0:BYN";
        String actual = taskInput.taskID(taskName, taskNumber, developerDetails);
        assertEquals(expected, actual);
    }
@Test
    public void task1andTask2DurattionCheck() {
        int expected = 18;
        int[] task1andtask2 = {duration, duration2};
        int actual = 0;
        for (int i = 0; i < 2; i++) {
            actual = taskInput.totalHours(task1andtask2[i]);
        }
        assertEquals(expected, actual);
    }
    
}
