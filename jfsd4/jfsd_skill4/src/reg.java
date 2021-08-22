

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
        
String name=request.getParameter("userName"); 
String email=request.getParameter("email");
int age=Integer.parseInt(request.getParameter("age"));
String address=request.getParameter("address");  
String pass=request.getParameter("userPass"); 

 
 

          
try{  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
      PreparedStatement ps=con.prepareStatement(  "insert into res_user values(?,?,?,?,?,?)");  

ps.setString(1,name);  
ps.setString(2,email);  
ps.setInt(3,age);  
ps.setString(4,address);  
ps.setString(5,pass); 
ps.setString(6,"cust"); 
          
int i=ps.executeUpdate();  
if(i>0)  
	 request.getRequestDispatcher("index.html").include(request, response); 
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  

}
