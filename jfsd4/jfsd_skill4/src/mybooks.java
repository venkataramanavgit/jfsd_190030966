

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
 * Servlet implementation class mybooks
 */
public class mybooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mybooks() {
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
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM mov_user where cust=? ");
			
			stmt.setString(1,name); 
            
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            out.println("<a href='cust.html'>home</a> |"); 
             
            out.println("<h1>Manage movies</h1>");  
              
            
              
            out.print("<table border='1' width='100%'");  
            
            out.print("<tr><th>mname</th><th>showtime</th><th> tickets price</th><th>tickets count</th><th>cancel</th></tr>");  
           
            while(rs.next()){
            	out.print("<tr><td>"+rs.getString("mname")+"</td><td>"+ rs.getString("shwtime")+"</td><td>"+rs.getInt("ctik")+"</td><td>"+rs.getInt("ptik")+"</td><td><a href='delbooks?id="+rs.getString("tid")+"'>cancel</a></td></tr>");  
              
            }
                }
        	catch (Exception e2) {System.out.println(e2);}  
          
         
        out.print("</table>");  
          
        out.close(); 
	}

}
