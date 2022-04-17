import java.sql.*;

public class prototype{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            String sql = "insert into employeeinfo(fullName, position) values('Karen Doe', '1')";
            PreparedStatement statement = connection.prepareStatement(sql);
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("A row has been inserted.");
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
}