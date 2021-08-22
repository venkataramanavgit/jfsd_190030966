

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class delbooks
 */
public class delbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delbooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		        
		String tid=request.getParameter("id");  
		
		

		
		try{  
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
			  PreparedStatement stmt1 = con.prepareStatement("SELECT mname,ctik,ptik FROM mov_user where tid=? ");
				
				stmt1.setString(1,tid); 
	            
	            stmt1.executeQuery();
	            ResultSet rs2 = stmt1.getResultSet();
	            rs2.next();
	            String mname=rs2.getString("mname");
	            int tp=rs2.getInt("ptik");
	            int cp=rs2.getInt("ctik");
	            
	            
				PreparedStatement stmt = con.prepareStatement("SELECT atik,ptik,btik,income FROM movies where mname=? ");
				
				stmt.setString(1,mname); 
	            
	            stmt.executeQuery();
	            ResultSet rs = stmt.getResultSet();
	            rs.next();
	            int atik=rs.getInt("atik");
	            int ptik=rs.getInt("ptik");
	            int btik=rs.getInt("btik");
	            int inc=rs.getInt("income");
	            
			
			PreparedStatement ps2=con.prepareStatement("update movies set btik=?,income=?,atik=? where mname=? "); 
	        ps2.setInt(1,btik-tp);  
	        ps2.setInt(2,inc-(cp));
	        ps2.setInt(3,atik+tp);
	        ps2.setString(4,mname);

	            
	   
		      PreparedStatement ps=con.prepareStatement( "delete from mov_user where tid=?");  
		      HttpSession session=request.getSession(false);
				String name=(String)session.getAttribute("name"); 
		ps.setString(1,tid);  
	

		
	
		          
		int j=ps.executeUpdate(); 
		 int i=ps2.executeUpdate();  
			
		 response.sendRedirect("mybooks"); 
			
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
}


}
