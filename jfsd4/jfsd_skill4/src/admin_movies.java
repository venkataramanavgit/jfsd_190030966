

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class admin_movies
 */
public class admin_movies extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_movies() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
			HttpSession session=request.getSession(false);
			String name=(String)session.getAttribute("name"); 
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM movies");
			
 
            
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            out.println("<a href='shan.html'>home</a> |"); 
           
            out.println("<h1>Overall bookings</h1>");  
              
            
              
            out.print("<table border='1' width='100%'");  
            
            out.print("<tr><th>mname</th><th>genre</th><th>Manager</th><th>available tickets</th><th>booked tickets</th><th>tickets price</th><th>income</th><th>edit</th><th>remove</th></tr>");  
           
            while(rs.next()){
            	out.print("<tr><td>"+rs.getString("mname")+"</td><td>"+ rs.getString("genre")+"</td><td>"+ rs.getString("own")+"</td><td>"+rs.getInt("atik")+"</td><td>"+rs.getInt("btik")+"</td><td>"+rs.getInt("ptik")+"</td><td>"+rs.getInt("income")+"</td><td>"+rs.getString("stat")+"</td><td><a href='medit?id="+rs.getString("mname")+"'>makeactive/inactive</a></td><td><a href='removemovie?id="+rs.getString("mname")+"'>delete</a></td></tr>");  
              
            }
                }
        	catch (Exception e2) {System.out.println(e2);}  
          
         
        out.print("</table>");  
          
        out.close(); 
	}

	}

	


