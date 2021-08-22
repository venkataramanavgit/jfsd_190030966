

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
 * Servlet implementation class makemanager
 */
public class makemanager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makemanager() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
			
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM res_user");
			
			
            
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            out.println("<a href='shan.html'>home</a>");  
            out.println("<h1>Manage customers and managers</h1>");  
              
            
              
            out.print("<table border='1' width='100%'");  
            out.print("<tr><th>Name</th><th>Password</th><th>Email</th><th>address</th><th>type</th><th>makeManger</th><th>RemoveasManager</th><th>Delete</th></tr>");  
           
            while(rs.next()){
            	out.print("<tr><td>"+rs.getString("name")+"</td><td>"+ rs.getString("pass")+"</td><td>"+rs.getString("email")+"</td><td>"+rs.getString("address")+"</td><td>"+rs.getString("sat")+"</td><td><a href='tomanager?id="+rs.getString("name")+"'>Makemanager</a></td><td><a href='tocust?id="+rs.getString("name")+"'>removeasmanager</a></td><td><a href='removeuser?id="+rs.getString("name")+"'>delete</a></td></tr>");  
              
            }
                }
        	catch (Exception e2) {System.out.println(e2);}  
          
         
        out.print("</table>");  
          
        out.close();  
	}



}
