//this class will contain all methods to send items to the database
//for now everything is mostly strings but may later be changed to 
//objects or other types after testing further in development
//all changes will call the saveToLog method

import java.sql.*;

public class SendToDatabase {

    private Connection con;
    private Statement stmt;

    public SendToDatabase(Connection connection) throws SQLException {
        con = connection;
        stmt = con.createStatement();
    }

    public int createEmployee(String employeeName, String emailAddress, String address, String phoneNumber, int position){
        //set employee name to new column in database
        //get and return the employee position in database as
        //six digit employee number
        //set employee to active in the database
        int employeeID = -1;
        try {
            stmt.executeUpdate("INSERT INTO employee VALUES (NULL, '"
                                + employeeName + "', '"
                                + emailAddress + "', '"
                                + address + "', '"
                                + phoneNumber + "', "
                                + position + ")", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                employeeID = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
        
        return employeeID;
    }

    public void editEmployeeName(String newEmployeeName, int employeeID){
        //change name in database
        try {
            stmt.executeUpdate("UPDATE employee SET name=" + newEmployeeName + " WHERE empID=" + employeeID);
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
    }

    public void editManagerStatus(boolean isManager, int employeeID){
        //set manager status to 1 (true) or 0 (false) in the database
        try {
            stmt.executeUpdate("UPDATE employee SET position=" + isManager + " WHERE empID=" + employeeID);
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
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
