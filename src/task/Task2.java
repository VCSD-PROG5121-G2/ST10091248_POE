package task.pkg1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Tevessan Naidoo
 */
public class Task2 {

    String taskName;
    String taskDescription;
    String developerDetails;
    String taskID;
    String taskStatus;
    int taskNumber;
    int taskDuration;

    public String taskID(String taskName, int taskNumber, String storeName) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.developerDetails = storeName;

        return taskName.toUpperCase().substring(0, 2) + ":" + taskNumber + ":" + storeName.toUpperCase().substring(storeName.length() - 3);
    }
   public String allTaskDetails(String taskStatus, String developerDetails, int taskNumber, String taskName, String taskDescription, String taskID, int duration){
        this.taskStatus = taskStatus;
        this.developerDetails = developerDetails;
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskID = taskID;
        return "Task Status: "+taskStatus +"\n"+  "Developer Details: "+developerDetails +"\n"+  "Task Number: "+ taskNumber +"\n"+
                "Task Name: "+taskName +"\n"+  "Task Description: "  +taskDescription +"\n"+ "Task ID: "+taskID +"\n"+  "Duration: " +duration;
    } 
   public boolean taskDescription(String task){
        this.taskDescription = task;
        if(task.length() > 50){
            return false;
        }else
            return true;
    }
   public int totalHours(int duration){
        this.taskDuration = this.taskDuration + duration;
        return this.taskDuration;
    }
}

