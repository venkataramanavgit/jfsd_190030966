

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

/**
 * Servlet implementation class medit
 */
public class medit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public medit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mname=request.getParameter("id");  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
        
try{  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
	PreparedStatement ps=con.prepareStatement("select stat from movies where mname=? "); 
	ps.setString(1,mname);
	ps.executeQuery();
    ResultSet rs = ps.getResultSet();
    rs.next();
    if(rs.getString("stat").equals("active")) {
    PreparedStatement ps1=con.prepareStatement("update movies set stat=? where mname=? "); 
    ps1.setString(1,"inactive");  
    ps1.setString(2,mname); 

        
int i=ps1.executeUpdate(); 
response.sendRedirect("movies_manage"); }
    else {
    	PreparedStatement ps2=con.prepareStatement("update movies set stat=? where mname=? "); 
        ps2.setString(1,"active");  
        ps2.setString(2,mname); 

            
    int i=ps2.executeUpdate();  
    response.sendRedirect("movies_manage"); }
    
 

	 
        
}catch (Exception e2) {System.out.println(e2);} 
	}

	

}
