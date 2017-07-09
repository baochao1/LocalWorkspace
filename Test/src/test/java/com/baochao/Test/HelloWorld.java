package com.baochao.Test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 7948154388083161151L;
private String message;

  public void init() throws ServletException
  {
      message = "Hello World";
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      out.println("<h1>" + message + "</h1>");
  }
  
  public void destroy()
  {
	  
  }
}