

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
       
          
        HttpSession session=request.getSession(false);  
        if(session!=null){  
        String name=(String)session.getAttribute("name"); 
        String pass=(String)session.getAttribute("pass"); 
        if(pass.equals("admin123")){
        	request.getRequestDispatcher("shan.html").include(request, response);  
        }
        else {
        	String dbsat=(String)session.getAttribute("sat");
        	if(dbsat.equals("cust")) {
        		request.getRequestDispatcher("cust.html").include(request, response);  
        	}
        	else {
        		request.getRequestDispatcher("mang.html").include(request, response);
        	}
        }
        

        out.print("Hello, "+name+" Welcome to Profile");  
        }  
        else{  
            out.print("Please login first");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }  
        out.close();  
	}

	

}
