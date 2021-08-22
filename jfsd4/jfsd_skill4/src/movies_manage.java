

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
 * Servlet implementation class movies_manage
 */
public class movies_manage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public movies_manage() {
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
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM movies where own=? ");
			
			stmt.setString(1,name); 
            
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            out.println("<a href='mang.html'>home</a> |"); 
            out.println("<a href='admov.html'>addmovies</a>"); 
            out.println("<h1>Manage movies</h1>");  
              
            
              
            out.print("<table border='1' width='100%'");  
            
            out.print("<tr><th>mname</th><th>genre</th><th>available tickets</th><th>booked tickets</th><th>tickets price</th><th>income</th><th>edit</th><th>remove</th></tr>");  
           
            while(rs.next()){
            	out.print("<tr><td>"+rs.getString("mname")+"</td><td>"+ rs.getString("genre")+"</td><td>"+rs.getInt("atik")+"</td><td>"+rs.getInt("btik")+"</td><td>"+rs.getInt("ptik")+"</td><td>"+rs.getInt("income")+"</td><td>"+rs.getString("stat")+"</td><td><a href='medit?id="+rs.getString("mname")+"'>makeactive/inactive</a></td><td><a href='removemovie?id="+rs.getString("mname")+"'>delete</a></td></tr>");  
              
            }
                }
        	catch (Exception e2) {System.out.println(e2);}  
          
         
        out.print("</table>");  
          
        out.close(); 
	}

	

}
