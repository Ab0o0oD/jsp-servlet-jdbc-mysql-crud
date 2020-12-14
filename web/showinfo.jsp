<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 12/14/2020
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<h1>User Info</h1>
<p>Hello ${firstName} ${lastName}</p>
<%
String firstName = (String) request.getAttribute( "firstName" );
    String lastName = (String) request.getAttribute( "lastName" );
    String email = (String) request.getAttribute( "email" );
    String password = (String) request.getAttribute( "password" );
    System.out.println(firstName+lastName+email+password);


    String INSERT_EMP_SQL = "INSERT INTO employees( first_name, last_name, email, password)"
            + " VALUES (?,?,?,?)";


    Connection connection = null;

    try {
        Class.forName( "com.mysql.cj.jdbc.Driver" );
        connection = DriverManager
                .getConnection( "jdbc:mysql://127.0.0.1:3306/users", "root", "" );
    } catch (SQLException | ClassNotFoundException e) {
        System.out.println("error connecting to database");
        e.printStackTrace();
    }

    int resault = 0;

    if (connection != null) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement( INSERT_EMP_SQL );

            preparedStatement.setString( 1, firstName );
            preparedStatement.setString( 2, lastName);
            preparedStatement.setString( 3, email);
            preparedStatement.setString( 4, password );
            resault = preparedStatement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }



%>
</body>
</html>
