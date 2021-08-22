

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
          
        if(password.equals("admin123")){
        	request.getRequestDispatcher("shan.html").include(request, response);  
        out.print("Welcome, "+name);  
        HttpSession session=request.getSession();  
        session.setAttribute("name",name);
        session.setAttribute("pass",password);
        }  
        else{ 
        	try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/KLEF","root","ROOT");
			
			PreparedStatement stmt = con.prepareStatement("SELECT name, pass,sat FROM res_user where name=?");
			stmt.setString(1,name); 
			
            
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            String dbUsername = null;
            String dbPassword = null;
            String dbsat = null;
            while(rs.next()){
                dbUsername = rs.getString("name");
                dbPassword = rs.getString("pass");
                dbsat = rs.getString("sat");
            }

                if(dbUsername.equals(name) && dbPassword.equals(password)){
                	HttpSession session=request.getSession();  
                    session.setAttribute("name",name); 
                    session.setAttribute("pass",password);
                    session.setAttribute("sat",dbsat);
                         
                		out.print("Welcome, "+name);  
                	if(dbsat.equals("cust")) {
                		request.getRequestDispatcher("cust.html").include(request, response);  
                	}
                	else {
                		request.getRequestDispatcher("mang.html").include(request, response);
                	}
                	
                        
                	}
                	else {
                		 
                		out.print("Sorry, username or password error!");  
                        request.getRequestDispatcher("login.html").include(request, response);  
                         
                	}
                   
                }
        	catch (Exception e2) {System.out.println(e2);}  
        
		out.close();  
        }
	}

        
	}


