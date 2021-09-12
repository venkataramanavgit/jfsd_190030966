<%@ page import = "java.io.*" %>
 <%@ page import = "java.sql.*" %>
 <%@ page  import="javax.servlet.*" %>
<%
String name=request.getParameter("userName"); 
String email=request.getParameter("email");
String pass=request.getParameter("userPass"); 
try{  
	  Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
    PreparedStatement ps=con.prepareStatement(  "insert into book_user values(?,?,?)");  
ps.setString(1,email);  
ps.setString(2,name);  
 
ps.setString(3,pass); 

        
int i=ps.executeUpdate();  
if(i>0)  
	 request.getRequestDispatcher("register.jsp").include(request, response);  

    
        
}catch (Exception e2) {System.out.println(e2);}  
        
 

%>