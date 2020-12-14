package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeServlet", urlPatterns = ("/test"))
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
