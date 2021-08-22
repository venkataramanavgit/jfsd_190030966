

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
 * Servlet implementation class viewtik
 */
public class viewtik extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewtik() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
			HttpSession session=request.getSession(false);
			String name=(String)session.getAttribute("name"); 
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM movies where stat=?");
			stmt.setString(1, "active");
			
			
            
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            out.println("<a href='cust.html'>home</a> |"); 
            out.println("<a href='mybooks'>mybookings</a>"); 
            out.println("<h1>Book tickets</h1>");  
              
            
              
            out.print("<table border='1' width='100%'");  
            
            out.print("<tr><th>mname</th><th>genre</th><th>owner</th><th>available tickets</th><th>tickets price</th><th>booknow</th></tr>");  
           
            while(rs.next()){
            	out.print("<tr><td>"+rs.getString("mname")+"</td><td>"+ rs.getString("genre")+"</td><td>"+ rs.getString("own")+"</td><td>"+rs.getInt("atik")+"</td><td>"+rs.getInt("ptik")+"</td><td><a href='booknow.html'>booknow</a></td></tr>");  
              
            }
                }
        	catch (Exception e2) {System.out.println(e2);}  
          
         
        out.print("</table>");  
          
        out.close(); 
	}

	
}
