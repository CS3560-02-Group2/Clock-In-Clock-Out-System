import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class prototype{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "****";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            Statement statement = (Statement) connection.createStatement();
            ResultSet resultSet = ((java.sql.Statement) statement).executeQuery( 
                "insert into timepunchinfo(id, dateInfo, clockIn, beginBreak, endBreak, clockOut)" + "values('1', '2022-04-14','12:00:00', '17:00:00', '17:30:00','20:00:00')"
                );
            while (resultSet.next()){
                System.out.println(resultSet.getString("fullName"));
            }
        } catch (SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);    
            //e.printStackTrace();
            }
    }
}