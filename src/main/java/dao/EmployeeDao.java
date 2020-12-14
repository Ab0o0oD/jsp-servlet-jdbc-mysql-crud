package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {
    private static final String INSERT_EMP_SQL = "INSERT INTO employees( first_name, last_name, email, password)"
            + " VALUES (?,?,?,?)";


    private Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            connection = DriverManager
                    .getConnection( "jdbc:mysql://127.0.0.1:3306/users", "root", "" );
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error connecting to database");
            e.printStackTrace();
        }
        return connection;
    }

    public int registerEmployee(Employee e)   {

        int resault = 0;

        Connection connection = getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement( INSERT_EMP_SQL );
                //first p
                preparedStatement.setString( 1, e.getFirstName() );
                preparedStatement.setString( 2, e.getLastName() );
                preparedStatement.setString( 3, e.getEmail() );
                preparedStatement.setString( 4, e.getPassword() );
                resault = preparedStatement.executeUpdate();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
//return 1 if execution succeed
        return resault;
    }

    public static void main(String[] args) {
        Employee employee = new Employee( "Abod", "jamal", "a@bobobo.com", "passpass" );
        EmployeeDao e = new EmployeeDao();
        System.out.println();
            System.out.println( e.registerEmployee( employee ) );


    }


}
