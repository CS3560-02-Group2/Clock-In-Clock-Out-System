//This class contains all methods relating to getting data from the database
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.text.Position;

public class getFromDatabase {
    /*
    // Try to create a class for just connecting Data Base to avoid repetition in each code
    public static void connectToDatabase(){
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);    
            //e.printStackTrace();
            }
    }
    */

    public static void addBeginShift(int id, String currentTime){
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak = '{0}' WHERE id=2;", currentTime);
            String sql = String.format("UPDATE timepunchinfo SET beginBreak='%s' WHERE id='%d';", currentTime, id);
            PreparedStatement statement = connection.prepareStatement(sql);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Database Updated");
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);    
            //e.printStackTrace();
            }
    }

    public static void addBeginBreak(String currentTime){
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak = '{0}' WHERE id=2;", currentTime);
            String sql = String.format("UPDATE timepunchinfo SET beginBreak='%s' WHERE id=2;", currentTime);
            PreparedStatement statement = connection.prepareStatement(sql);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Database Updated");
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);    
            //e.printStackTrace();
            }
    }

    public static void addEmp(String fullName, int position){
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            String sql = String.format("insert into employeeinfo(fullName, position) values({0}, {1})", fullName, position);
            PreparedStatement statement = connection.prepareStatement(sql);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Database Updated");
            }
            statement.close();
            connection.close();
            /*Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery( 
                //"insert into timepunchinfo(id, dateInfo, clockIn, beginBreak, endBreak, clockOut)" + "values('1', '2022-04-14','12:00:00', '17:00:00', '17:30:00','20:00:00')"
                "select * from employeeinfo"
                );
            while (resultSet.next()){
                System.out.println(resultSet.getString("fullName"));
            }*/
        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);    
            //e.printStackTrace();
            }
    }

    
    public static int confirmLogin(int inputID){
        //check input employee ID, if it exists check if it is active
        //if it is active return the employee name/ display the employee window
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";
        int id = 0;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak = '{0}' WHERE id=2;", currentTime);
            String sql = String.format("SELECT * FROM employeeinfo WHERE id= %d;",inputID);
            // create the java statement
            Statement statement = connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = statement.executeQuery(sql);
            
            // iterate through the java resultset
            while (rs.next())
            {
                id = rs.getInt("id");
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
