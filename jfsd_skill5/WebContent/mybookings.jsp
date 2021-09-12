<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import = "java.io.*" %>
 <%@ page import = "java.sql.*" %>
 <%@ page  import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
#grad{
   background-image: url('black.png');
 
  }
  #grad1{
   background-color:teal ;
 
  }
</style>
<body>
<div id="grad">
<center><h1 style="color:white;">Welcome To Book Store</h1></center>
</div>
<%String name=(String)session.getAttribute("name");  
out.print("Hello "+name);   %>
<br>
<button onclick="window.location='home.jsp'">Home</button>


<% 
  


	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
	
	PreparedStatement stmt = con.prepareStatement("SELECT * FROM cart where user=?");
	
	stmt.setString(1,name);
    
    stmt.executeQuery();
    ResultSet rs = stmt.getResultSet();
%>
<div id="grad1">
   	<table border='1' width='100%'>
   	<tr><th>name of the book</th><th>Price</th><th>remove</th></tr>
   	<% int number =0;
    while(rs.next()){
    	%>
 <% number=number+rs.getInt("price");%>
<tr><td>"<%=rs.getString("name") %>"</td><td>"<%=rs.getInt("price") %>"</td><td><a href='remov.jsp?name=<%=rs.getString("name") %>'>Remove</a></td></tr>
    <%   
    }
%>
</table>
<h1>total:Rs.<%=number %>/-</h1>
</div>
</body>
</html>