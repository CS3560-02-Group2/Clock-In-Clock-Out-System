import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.text.Position;

/**
 * Utility class that sends querys to database that 
 * select data from it.
 */
public class getFromDatabase {
    
    //check input employee ID, if it exists check if it is active
    //if it is active return the employee name / display the employee window
    public static int[] confirmLogin(int inputID){
        int id = 0;
        int position = 0;
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
                position = rs.getInt("position");
                
                // print the results
                System.out.format("%s, %s, %s\n", id, fullName, position);
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);    
            //e.printStackTrace();
            }
        return new int[]{id, position};   
    }

    //returns employee information from database as a 2D String array consisting of (id, name, position) as strings
    public static String[][] getEmployees(){
        List<List<String>> employees = new ArrayList<>();
        try {
            Connection connection = setUpConnection();
            System.out.println("Database connected!");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                employees.add(Arrays.asList(rs.getString("empID"), rs.getString("fullName"), 
                posAsString(rs.getInt("position"))));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        String[][] empArr = new String[employees.size()][];
        for (int i = 0; i < employees.size(); i++) {
            empArr[i] = employees.get(i).toArray(new String[employees.get(i).size()]);
        }

        return empArr;
    }

    //helper function returning the position name (employee, manager) for the
    //provided position number (0, 1)
    private static String posAsString(int pos) {
        return (pos == 0) ? "employee" : "manager";
    }

    //returns shift information from database as a 2D String array consisting of all columns as strings
    public static String[][] getShifts() {
        List<List<String>> shifts = new ArrayList<>();
        try {
            Connection connection = setUpConnection();
            System.out.println("Database connected!");
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM shift");
            while (rs.next()) {
                shifts.add(Arrays.asList(rs.getString("empID"), rs.getString("date"), 
                rs.getString("timeClockedIn"), rs.getString("breakStart"), rs.getString("breakEnd"),
                rs.getString("timeClockedOut")));
            }
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

        String[][] shiftArr = new String[shifts.size()][];
        for (int i = 0; i < shifts.size(); i++) {
            shiftArr[i] = shifts.get(i).toArray(new String[shifts.get(i).size()]);
        }

        return shiftArr;
    }

    //sets up and returns connection to database
    private static Connection setUpConnection(){
        String url = "jdbc:mysql://localhost:3306/employee"; //make sure this is correct url to your local database
        String username = "root"; //make sure this is correct username to your local database
        String password = "password"; //make sure this is correct password to your local database
        Connection connection;
        
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e); //database connection failed
        }

        return connection;
    }

}
