

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class removemovie
 */
public class removemovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removemovie() {
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
    PreparedStatement ps=con.prepareStatement("delete from movies where mname=? "); 
    ps.setString(1,mname);  
 

        
int i=ps.executeUpdate();  
 

	 response.sendRedirect("movies_manage");  
        
}catch (Exception e2) {System.out.println(e2);}  
	}


}
