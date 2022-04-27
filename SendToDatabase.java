//this class will contain all methods to send items to the database

import java.sql.*;


public class SendToDatabase {

    public static int createEmployee(String employeeName, int position){
        //set employee info to new row in database and return employee's ID
        int employeeID = -1;
        Connection con = setUpConnection();
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO employee VALUES (NULL, '"
                                + employeeName + "', '"
                                + position + ")", Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                employeeID = rs.getInt(1);
                stmt.executeUpdate("INSERT INTO employee_archv VALUES ("
                                + employeeID + ", '"
                                + employeeName + "', '"
                                + position + ")", Statement.RETURN_GENERATED_KEYS);
                System.out.println("Employee Inserted");
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
        
        return employeeID;
    }

    public static void editEmployeeName(String newEmployeeName, int employeeID){
        //change name in database
        Connection con = setUpConnection();
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("UPDATE employee SET fullName=" + newEmployeeName + " WHERE empID=" + employeeID);
            if (rows > 0) {
                stmt.executeUpdate("UPDATE employee_archv SET fullName=" + newEmployeeName + " WHERE empID=" + employeeID);
                System.out.println("Database Updated");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
    }

    public static void editManagerStatus(boolean isManager, int employeeID){
        //set manager status to 1 (true) or 0 (false) in the database
        Connection con = setUpConnection();
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate("UPDATE employee SET position=" + isManager + " WHERE empID=" + employeeID);
            
            if (rows > 0) {
                stmt.executeUpdate("UPDATE employee_archv SET position=" + isManager + " WHERE empID=" + employeeID);
                System.out.println("Database Updated");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
    }

    //adds start of shift into the database for the employee logged in
    public static void addBeginShift(String currentDate, String currentTime){
        Connection con = setUpConnection();
        int employeeID = TimeClockMain.tempID;
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(String.format("INSERT INTO shift(empID, date, timeClockedIn) values(%d,'%s','%s')"
                                            , employeeID, currentDate, currentTime));
            if (rows > 0) {
                stmt.executeUpdate(String.format("INSERT INTO shift_archv(empID, date, timeClockedIn) values(%d,'%s','%s')"
                                            , employeeID, currentDate, currentTime));
                System.out.println("Database Updated");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
    }

    //adds end of shift into the database for the employee logged in and date provided
    public static void addEndShift(String currentDate, String currentTime){
        Connection con = setUpConnection();
        int employeeID = TimeClockMain.tempID;
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(String.format("UPDATE shift SET timeClockedOut='%s' WHERE empID=%d AND date='%s'"
                                            , currentTime, employeeID, currentDate));
            if (rows > 0) {
                stmt.executeUpdate(String.format("UPDATE shift_archv SET timeClockedOut='%s' WHERE empID=%d AND date='%s'"
                                            , currentTime, employeeID, currentDate));
                System.out.println("Database Updated");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
    }

    //adds start of break into the database for the employee logged in and date provided
    public static void addBeginBreak(String currentDate, String currentTime){
        Connection con = setUpConnection();
        int employeeID = TimeClockMain.tempID;
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(String.format("UPDATE shift SET breakStart='%s' WHERE empID=%d AND date='%s'"
                                            , currentTime, employeeID, currentDate));
            if (rows > 0) {
                stmt.executeUpdate(String.format("UPDATE shift_archv SET breakStart='%s' WHERE empID=%d AND date='%s'"
                                            , currentTime, employeeID, currentDate));
                System.out.println("Database Updated");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
    }

    //adds end of break into the database for the employee logged in and date provided
    public static void addEndBreak(String currentDate, String currentTime){
        Connection con = setUpConnection();
        int employeeID = TimeClockMain.tempID;
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(String.format("UPDATE shift SET breakEnd='%s' WHERE empID=%d AND date='%s'"
                                            , currentTime, employeeID, currentDate));
            if (rows > 0) {
                stmt.executeUpdate(String.format("UPDATE shift_archv SET breakEnd='%s' WHERE empID=%d AND date='%s'"
                                            , currentTime, employeeID, currentDate));
                System.out.println("Database Updated");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
    }

    public static void removeEmployee(int employeeID) {
        Connection con = setUpConnection();
        try {
            Statement stmt = con.createStatement();
            int rows = stmt.executeUpdate(String.format("DELETE FROM employee WHERE empID=%d", employeeID));
            if (rows > 0) {
                System.out.println("Employee Removed");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Could not update data to the database " + e.getMessage());
        }
    }
    
    private static Connection setUpConnection(){
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";
        Connection connection;
        
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        return connection;
    }
}
