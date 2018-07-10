package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

  public static final String URL      = "jdbc:mysql://localhost:3306";
  public static final String USER     = "root";
  public static final String PASSWORD = "admin";

  public static void main(String[] args) {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("select * from practice1.person");
      while (rs.next()) {
        System.out.println(rs.getString("LastName"));
      }

      connection.close();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
