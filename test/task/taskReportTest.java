package task;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tevessan Naidoo
 */

import org.junit.Test;
import static java.lang.Double.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class taskReportTest {
    
     //arrays for testing 
     String [] Developer = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};
     String [] taskNames = {"Create Login","Create Add Features","Create Reports","Add Arrays"};
     String [] taskId = {"MK:0:ATE","ED:1:ADD","SAM:2:RES","GLE:3:AYS"};
     int [] taskDuration = {5,8,2,11};
     String [] taskStatus = {"To Do","Doing","Done","To Do"};
     String [] description = {"Creating loing in","adding feateure","Creating Reports","add arrays"};
    
     //report object
     TaskReport reportMethod = new TaskReport();
     
     
     //to test developers with status done
     @Test
     public void displayDevelopersWithStatusDone(){
        reportMethod.setReport(Developer, taskNames, taskId, taskDuration, taskStatus, description);
        String Create = "Create Reports";
        String actual = "\nDeveloper: "+ "Samantha Paulson" + "\n Task Name: " +Create;
        String expected = reportMethod.displayDevelopersWithDone();
         assertEquals(expected, actual);
     }
     
     
     //longest Duration developers test
    @Test
    public void LongestDuration(){
        reportMethod.setReport(Developer, taskNames, taskId, taskDuration, taskStatus, description);
        String actual = reportMethod.longestDuration();
        String expected = "11, Glenda Oberholzer";
        assertEquals(expected, actual);
    }
    
    //search dev with task status name test
    @Test 
    public void taskDevStatus(){
        reportMethod.setReport(Developer, taskNames, taskId, taskDuration, taskStatus, description);
        String name = "Create Login";
        String devloperName = "Mike Smith";
        String actual = reportMethod.taskDevStatus(name);
        String expected =  "\nTask name: "+name +"" +"\n Developer name: "+ devloperName+"" +"\n Task status: "+ taskStatus[0];
       
        assertEquals(expected, actual);
    }
    
    
    //search task with developer name test
    @Test
    public void searchTaskWithDeveloperName(){
        reportMethod.setReport(Developer, taskNames, taskId, taskDuration, taskStatus, description);
        String devName = "Samantha Paulson";
        String task = "Create Reports";
        String actual = reportMethod.getdevNameTaskStatus(devName);
        String expected = "Name: "+ devName + " Task Name: "+task+ " Task Status: " + taskStatus[2];
        assertEquals(expected, actual);
    }
     
    
    //deleting task test
    @Test
    public void deleteTask(){
        reportMethod.setReport(Developer, taskNames, taskId, taskDuration, taskStatus, description);
        String name = "Create Reports";
        String expected = "Entry “ "+ name + "” successfully deleted";
        String actual = reportMethod.delTask(name);
        assertEquals(expected, actual);
    }
   
    //displaying the report test
    @Test
    public void displayReport(){
        reportMethod.setReport(Developer, taskNames, taskId, taskDuration, taskStatus, description);
        String storeData = "";
        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < Developer.length; i++) {
                storeData = "Developer name: " + Developer[i] + "\t\n Task name: " +
                    taskNames[i] + "\t\n Task Description: "+description[i]+ "\t\n Task ID: "+taskId[i] + "\t\n Task Duration: "
                    + taskDuration[i] + "\t\n Task Status: "+taskStatus[i] + "\t\n";
                sum.append(storeData);
            }
        String expected = sum.toString();
        String actual = reportMethod.showTask();
        assertEquals(expected, actual);
}
    
    
}
