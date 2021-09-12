<%@ page import = "java.io.*" %>
 <%@ page import = "java.sql.*" %>
 <%@ page  import="javax.servlet.*" %>
 <%@ page import="javax.servlet.http.HttpSession" %>
  
<%String name=(String)session.getAttribute("name");  
String book=(String)request.getParameter("name") ;
String bp=(String)request.getParameter("p") ;
Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
  PreparedStatement ps=con.prepareStatement(  "delete from  cart where name=? and user=?");  
ps.setString(1,book);  
ps.setString(2,name);  


      
int i=ps.executeUpdate();  
if(i>0)  
	 request.getRequestDispatcher("mybookings.jsp").include(request, response);  
else{
	out.print("unsuccessfull");
}
  

%>
 