

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addmovie
 */
public class addmovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addmovie() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		        
		String mname=request.getParameter("mname"); 
		String genre=request.getParameter("genre");
		int atik=Integer.parseInt(request.getParameter("atik"));
		int ptik=Integer.parseInt(request.getParameter("ptik"));
		
		try{  
			  Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
		      PreparedStatement ps=con.prepareStatement(  "insert into movies values(?,?,?,?,?,?,?,?)");  
		      HttpSession session=request.getSession(false);
				String name=(String)session.getAttribute("name"); 
		ps.setString(1,mname);  
		ps.setString(2,name);
		ps.setString(3,genre);  
		ps.setInt(4,atik);  
		ps.setInt(5,0); 
		ps.setInt(6,ptik); 
		ps.setInt(7,0); 
		ps.setString(8,"inactive");  
		
	
		          
		int i=ps.executeUpdate();  
	
		 response.sendRedirect("movies_manage"); 
		  
		      
		          
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
	}

}
