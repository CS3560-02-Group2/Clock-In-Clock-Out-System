//This class contains all methods relating to getting data from the database

public class getFromDatabase {
    
    public String confirmLogin(int inputID){
        //check input employee ID, if it exists check if it is active
        //if it is active return the employee name/ display the employee window
    }

    public List getEmployees(){
        //get a list of all employees names/IDs and return them, for use in the manager window
    }

    public List getAllHours(int employeeID){
        //return a list of all shifts for an employee from the database to be edited
        //in the manager window
    }

    public List getPayPeriodHours(int employeeID, String payPeriod){
        //Get a list of shifts the employee has worked during the input pay period
    }

    public boolean getActiveStatus(int employeeID){
        //checks if an employee is set as active in the database, returns boolean
    }

    public list getDataLogs(){
        //return a list of log entries from the database
    }
}
