package dao;

import model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao {

    public static int registerEmployee(Employee e) throws ClassNotFoundException {
        String INSERT_USER_SQL = "INSERT INTO employees(id, first_name, last_name, email, password)"
                + " VALUES (?,?,?,?,?)";

        int resault = 0;

        Class.forName( "com.mysql.cj.jdbc.Driver" );
        try (Connection conn = DriverManager
                .getConnection( "jdbc:mysql://127.0.0.1:3306/users", "root", "" );

             PreparedStatement preparedStatement = conn.prepareStatement( INSERT_USER_SQL )) {

            preparedStatement.setInt( 1, 1 );
            preparedStatement.setString( 2, e.getFirstName() );
            preparedStatement.setString( 3, e.getLastName() );
            preparedStatement.setString( 4, e.getEmail() );
            preparedStatement.setString( 5, e.getPassword() );

            resault = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resault;

    }

    public static void main(String[] args) {
        Employee employee = new Employee( 1, "Ahmad", "jamal", "a@bobobo.com", "passpass" );

        try {
            System.out.println(registerEmployee(employee));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }



}
