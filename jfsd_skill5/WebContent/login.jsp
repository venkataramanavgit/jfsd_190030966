<%@ page import = "java.io.*" %>
 <%@ page import = "java.sql.*" %>
 <%@ page  import="javax.servlet.*" %>
 <%@ page import="javax.servlet.http.HttpSession" %>
 
<% 
String email=request.getParameter("email");  
String password=request.getParameter("pass");  

	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
	
	PreparedStatement stmt = con.prepareStatement("SELECT email,name, pass FROM book_user where email=?");
	stmt.setString(1,email); 
	
    
    stmt.executeQuery();
    ResultSet rs = stmt.getResultSet();
    String dbUsername = null;
    String dbPassword = null;
    String dbname = null;
    while(rs.next()){
        dbUsername = rs.getString("email");
        dbname=rs.getString("name");
        dbPassword = rs.getString("pass");
       
    }

        if(dbUsername.equals(email) && dbPassword.equals(password)){
         
            session.setAttribute("name",dbname); 
            session.setAttribute("pass",password);
           
                 
        		
        	
        		request.getRequestDispatcher("home.jsp").include(request, response);
        	}
        	
                
        	
        	else {
        		 
        		out.print("Sorry, username or password error!");  
                request.getRequestDispatcher("index.html").include(request, response);  
                 
        	}
           
        }
	catch (Exception e2) {System.out.println(e2);}   %>