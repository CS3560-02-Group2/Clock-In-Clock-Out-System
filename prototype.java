import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import java.text.*;
//use this file to test connection to your local database
public class prototype{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employee";
        String username = "root";
        String password = "password";

        try {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            //String currentTime = formatter.format(calendar.getTime());
            //String currentTime = "08:40:00";
            //System.out.println(currentTime);
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
            // Passing in the value as a string argument to mySQL syntax is wrong
            
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak = '69:42:00' WHERE id=2;"); // This is working
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak = '{0}' WHERE id=2;", currentTime); //Nope
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak =" + currentTime + "WHERE id=2;"); //NOPE
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak = {0} WHERE id=2;", currentTime); //Nope
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak=%s WHERE id=2;", currentTime); //Nope, but got the closet result out of the bunch. It register :40:00
            //String sql = String.format("UPDATE timepunchinfo SET beginBreak='%s' WHERE id=2;", currentTime); // FKKKK YESSSSSSS, so this is the right syntax for it.
            
            // Passing in the value as an int argument to mySQL, maybe syntax is wrong

            String sql = String.format("SELECT * FROM employeeinfo WHERE id=6;");

            //PreparedStatement statement = connection.prepareStatement(sql);
            //int rows = statement.executeUpdate();
            //if (rows > 0) {
            //    System.out.println("Database Updated");
            //}
            
            // create the java statement
            Statement statement = connection.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = statement.executeQuery(sql);
            
            // iterate through the java resultset
            while (rs.next())
            {
                int id = rs.getInt("id");
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
    }
}
