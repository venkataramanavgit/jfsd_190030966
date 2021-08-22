

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
 * Servlet implementation class booknow
 */
public class booknow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booknow() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
				response.setContentType("text/html");  
				PrintWriter out = response.getWriter();  
				        
				String mname=request.getParameter("mname"); 
				String date=request.getParameter("date");
				int ntik=Integer.parseInt(request.getParameter("ntik"));
				Date date1 = Calendar.getInstance().getTime();  
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
				String strDate = dateFormat.format(date1); 
				
				try{  
					  Class.forName("com.mysql.cj.jdbc.Driver");
					  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
						PreparedStatement stmt = con.prepareStatement("SELECT atik,ptik,btik,income FROM movies where mname=? ");
						
						stmt.setString(1,mname); 
			            
			            stmt.executeQuery();
			            ResultSet rs = stmt.getResultSet();
			            rs.next();
			            int atik=rs.getInt("atik");
			            int ptik=rs.getInt("ptik");
			            int btik=rs.getInt("btik");
			            int inc=rs.getInt("income");
			            
					if(atik>=ntik) {
					PreparedStatement ps2=con.prepareStatement("update movies set btik=?,income=?,atik=? where mname=? "); 
			        ps2.setInt(1,btik+ntik);  
			        ps2.setInt(2,inc+(ntik*ptik));
			        ps2.setInt(3,atik-ntik);
			        ps2.setString(4,mname);

			            
			   
				      PreparedStatement ps=con.prepareStatement(  "insert into mov_user values(?,?,?,?,?,?)");  
				      HttpSession session=request.getSession(false);
						String name=(String)session.getAttribute("name"); 
				ps.setString(1,strDate);  
				ps.setString(2,name);
				ps.setString(3,mname);  
				ps.setString(4,date);  
				ps.setInt(5,ntik*ptik); 
				ps.setInt(6,ntik); 
				
				
			
				          
				int j=ps.executeUpdate(); 
				 int i=ps2.executeUpdate();  
					
				 response.sendRedirect("viewtik"); 
					}
					else {
						out.print("no avilable seats");
					}
				  
				      
				          
				}catch (Exception e2) {System.out.println(e2);}  
				          
				out.close();  
	}

}
