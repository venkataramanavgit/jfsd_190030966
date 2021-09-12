<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.io.*" %>
 <%@ page import = "java.sql.*" %>
 <%@ page  import="javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<style>
  #grad{
   background-image: url('black.png');
 
  }
* {
box-sizing: border-box;
}
h1 {
text-align: center;
}
.outer-grid {
display: flex;
flex-wrap: wrap;
padding: 0 4px;
}
.inner-grid {
flex: 25%;
max-width: 25%;
padding: 0 4px;
}
.inner-grid img {
margin-top: 8px;
width: 100%;
padding: 10px;
}
@media screen and (max-width: 800px) {
.inner-grid {
flex: 50%;
max-width: 50%;
}
}
@media screen and (max-width: 600px) {
.inner-grid {
flex: 100%;
max-width: 100%;
}

</style>

<body>
<div id="grad">
<center><h1 style="color:white;">Welcome To Book Store</h1></center>
</div>

<%String name=(String)session.getAttribute("name");  
out.print("Hello "+name);   %>
<br>
<button onclick="window.location='mybookings.jsp'">Go to cart</button>


<% 
  


	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
	
	PreparedStatement stmt = con.prepareStatement("SELECT * FROM book1");
	
	
    
    stmt.executeQuery();
    ResultSet rs = stmt.getResultSet();
%>
   	<div class="outer-grid">
   	<% 
    while(rs.next()){
    	%>
 <hr>
<div class="inner-grid">
<hr>
         <iframe src=<%=rs.getString("url")%> height="365" width="365" frameborder="0" scrolling="no" ></iframe>
                <h4>Name of the Book: <%=rs.getString("name") %></h4>
                <h5>Author of book: <%=rs.getString("auth")%></h5>
               <h5>price of the book: Rs:<%=rs.getInt("price") %>/-</h5>
              <a href='boog.jsp?name=<%=rs.getString("name")%>&&p=<%=rs.getInt("price") %>' >Add to cart</a>
              <br>
            </div>
    <%   
    }
%>
 </div>
</body>
</html>