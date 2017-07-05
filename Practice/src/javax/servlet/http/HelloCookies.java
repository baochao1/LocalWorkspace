package javax.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

public class HelloCookies {
	
	public void doGet(HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException {
		Cookie firistName = new Cookie("first_name", request.getParameter("first_name"));
		Cookie lastName = new Cookie("last_name", request.getParameter("last_name"));
		
		firistName.setMaxAge(60*60*24);
		lastName.setMaxAge(60*60*24);
		
		response.addCookie(firistName);
		response.addCookie(lastName);

		PrintWriter out = response.getWriter();
		
		String title = "设置Cookies 实例";
		
		String doType = "<!dotype html public \"-//w3c//dtd html 4.0 " +  "transitional//en\">\n";
		out.println(doType + "<html>\n" +
				    "<head><title>" + title + "</title></head>"+
					"<body bgcolor=\"#f0f0f0\">\n" +
				    "<h1 align=\"center\">" + title +"</h1>\n" +
					"<ul>\n" + 
				    " <li><b>姓名</b>: "
					+ request.getParameter("first_name") + "\n" +
				    "<li><b>姓氏</b>: "
					+ request.getParameter("last_name") + "\n" +
				    "</ul>\n" +
					"</body></html>");
	}
}
