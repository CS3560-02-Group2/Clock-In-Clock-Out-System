//This class contains all methods relating to getting data from the database
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class getFromDatabase {
    
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

    public static void addBeginShift(int year, int month, int day, int hour, int minute, int second){
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            
            LocalDate date = LocalDate.parse(year+"-"+(month+1)+"-"+day);
            LocalTime time = LocalTime.parse(hour+":"+minute+":"+second);
            String sql = String.format("insert into timepunchinfo(id, dateInfo, clockIn) values({0}, {1}, {2})", 2, date, time);

            /*String date = String.format("%d-%d-%d",year, month, day);
            String time = String.format("%d:%d:%d",hour, minute, second);
            String sql = String.format("insert into timepunchinfo(id, dateInfo, clockIn) values({0}, {1}, {2})", 2, date, time);*/
            
            /*String date = "8/29/2011 11:16:12 AM";
            String[] parts = date.split(" ");
            System.out.println("Date: " + parts[0]);
            System.out.println("Time: " + parts[1] + " " + parts[2]);*/

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
