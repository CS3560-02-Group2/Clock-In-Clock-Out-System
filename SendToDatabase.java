//this class will contain all methods to send items to the database
//for now everything is mostly strings but may later be changed to 
//objects or other types after testing further in development
//all changes will call the saveToLog method

public class SendToDatabase {

    public int createEmployee(String employeeName){
        int employeeID = 000000;//placeholder, delete this
        //set employee name to new column in database
        //get and return the employee position in database as
        //six digit employee number
        //set employee to active in the database
        return employeeID;
    }

    public void editEmployeeName(String newEmployeeName, int employeeID){
        //change name in database
    }

    public void editManagerStatus(boolean isManager){
        //set manager status to true or false in the database
    }

    public void addEmployeeHours(String employeeHours, int employeeID){
        //adds the shift into the database for the employee who matches
        //the ID
    }

    public void editEmployeeHours(String newHours, String oldHours, String managerName, int managerID){
        //get/ copy old hours from database, save it along with manager
        //name and ID to the log section of the database
        //find the old hours in database, change it to new hours
    }

    public void saveToLog(String managerName, int managerID, String changesMade){
        //saves a log of something changed in the database
    }
}
