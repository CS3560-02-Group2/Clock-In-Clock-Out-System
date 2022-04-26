//This class contains all methods relating to getting data from the database
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class getFromDatabase {
    
    public static int confirmLogin(int inputID){
        //check input employee ID, if it exists check if it is active
        //if it is active return the employee name/ display the employee window
        int id = 0;
        try {
            Connection connection = setUpConnection();
            //System.out.println("Database connected!");
            System.out.println("Database connected inside confirmLogin function");
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak = '{0}' WHERE id=2;", currentTime);
            String sql = String.format("SELECT * FROM employee WHERE empID= %d;",inputID);
            // create the java statement
            Statement statement = connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = statement.executeQuery(sql);
            
            // iterate through the java resultset
            while (rs.next())
            {
                id = rs.getInt("empID");
                String fullName = rs.getString("fullName");
                int position = rs.getInt("position");
                
                // print the results
                System.out.format("%s, %s, %s\n", id, fullName, position);
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);    
            //e.printStackTrace();
            }
        return id;   
    }

    public static List<List<String>> getEmployees(){
        //returns employee names and ids from data base as a List of Lists consisting of (id, name) pairs
        List<List<String>> employees = new ArrayList<>();
        try {
            Connection connection = setUpConnection();
            System.out.println("Database connected!");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT empID, fullName FROM employee");
            while (rs.next()) {
                employees.add(List.of(rs.getString("empID"), rs.getString("fullName")));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return employees;
    }

    // public List getAllHours(int employeeID){
    //     //return a list of all shifts for an employee from the database to be edited
    //     //in the manager window
    // }

    // public List getPayPeriodHours(int employeeID, String payPeriod){
    //     //Get a list of shifts the employee has worked during the input pay period
    // }

    // public boolean getActiveStatus(int employeeID){
    //     //checks if an employee is set as active in the database, returns boolean
    // }

    // public list getDataLogs(){
    //     //return a list of log entries from the database
    // }

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
