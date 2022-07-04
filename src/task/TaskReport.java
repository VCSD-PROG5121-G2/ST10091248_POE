/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package task;

import java.util.Arrays;

/**
 *
 * @author Tevessan Naidoo
 */
public class TaskReport {
     static String [] developer;
     static String [] tNames;
     static String [] tId;
     static int [] tDuration;
     static String [] tStatus;
     static String [] description;
    
     
     public void setReport(String [] developer,String [] tNames,String [] tId, int [] tDuration, String [] tStatus, String [] description){
        this.developer = developer;
        this.tNames = tNames;
        this.tId = tId;
        this.tDuration = tDuration;
        this.tStatus = tStatus;
        this.description = description;
    }
     
    public String displayDevelopersWithDone(){
        String done = "Done";
        String output = "";
        String all = "";
        for(int i = 0 ; i <tStatus.length;i++ ){
            if(tStatus[i].equals(done)){
                all = "\nDeveloper: "+ developer[i]+ "\n Task Name: " +tNames[i];
                output = output + all;
            }
        }
        return output;
    }
     
    public String longestDuration(){
        int fullAmount = tDuration[0];
        String devName = developer[0];
        for (int i = 0; i < tDuration.length; i++) {
            if (tDuration[i] > fullAmount) {
                fullAmount = tDuration[i];
                devName = developer[i];
            }
        }
         String r = Integer.toString(fullAmount);
         return r + ", "+ devName;
    }
     
    public String showDevelopers(){
        return Arrays.toString(this.developer);
    }
    
    public String getdevNameTaskStatus(String Name){
        String outcome = "";
        for (int i = 0; i < developer.length; i++) {
            if(developer[i].equals(Name)){
                outcome = "Name: "+ developer[i] + " Task Name: "+tNames[i]+ " Task Status: " + tStatus[i];
            }
        }
        return outcome;
    }
    
    public String delTask(String Task){
    String TaskStore = "";
    for (int i = 0; i < tNames.length; i++) {
        if(tNames[i].equals(Task)){

            TaskStore = tNames[i];
            tNames[i] = "";
            developer[i] = "";
            tId[i] = "";
            tDuration[i] = 0;
            tStatus[i] = "";
            description[i] = "";
 
            return "Entry “ "+ TaskStore + "” successfully deleted";
        }
    }
    return TaskStore;
}
    
    
    public String showTask(){
        String storeData;
        StringBuilder sum = new StringBuilder();
        for (int i = 0; i < developer.length; i++) {
            storeData = "Developer name: " + developer[i] + "\t\n Task name: " +
                    tNames[i] + "\t\n Task Description: "+description[i]+ "\t\n Task ID: "+tId[i] + "\t\n Task Duration: "
                    + tDuration[i] + "\t\n Task Status: "+tStatus[i] + "\t\n";
            sum.append(storeData);
        }
        return sum.toString();
    }
    
    public String taskDevStatus(String Name){
        String outcome = "";
        for (int i = 0; i < tNames.length; i++) {
            if(tNames[i].equals(Name)){
                outcome = "\nTask name: "+tNames[i] +"" +"\n Developer name: "+ developer[i]+"" +"\n Task status: "+ tStatus[i];
            }
        }
        return outcome;
    }
  
}
