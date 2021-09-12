<%@ page import = "java.io.*" %>
 <%@ page import = "java.sql.*" %>
 <%@ page  import="javax.servlet.*" %>

 
<%String name=(String)session.getAttribute("name");  
String book=(String)request.getParameter("name") ;
int bp=Integer.parseInt(request.getParameter("p")) ;
Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
  PreparedStatement ps=con.prepareStatement(  "insert into cart values(?,?,?)");  
ps.setString(1,book);  
ps.setString(2,name);  
ps.setInt(3,bp); 

      
int i=ps.executeUpdate();  
if(i>0)  
	 request.getRequestDispatcher("home.jsp").include(request, response);  
else{
	out.print("unsuccessfull");
}
  

%>
