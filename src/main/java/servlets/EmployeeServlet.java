package servlets;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "EmployeeServlet", urlPatterns = ("/register"))
public class EmployeeServlet extends HttpServlet {
    Connection connection = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println( "postingggg" );
        String firstName = request.getParameter( "firstName" );
        String lastName = request.getParameter( "lastName" );
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );

        if (firstName == null || lastName == null || email == null || password == null) {
            System.out.println( "you have to fill detailes" );
        } else {
          request.setAttribute( "firstName", firstName );
            request.setAttribute( "lastName", lastName );
            request.setAttribute( "email", email );
            request.setAttribute( "password", password );
        getServletContext().getRequestDispatcher( "/showinfo.jsp" ).forward( request,response );
        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println( "Getteing" );





        /*
        //forwording the request to another part of app html, jsp, another servlet...

        getServletContext().getRequestDispatcher( "" ).forward( request,response );
    */

        /*
        //redirect to another application (URL)
        response.sendRedirect( "www.website.com" );

        //the req and resp gonna come from the new servlet
        response.sendRedirect( "/anotherServlet" );
         */

        /*
        //Get parameteres that given in URL:
        String firstName= request.getParameter( "firstName" );
         */



    }
}
