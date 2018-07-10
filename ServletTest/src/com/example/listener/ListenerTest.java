package com.example.listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListenerTest extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * print html page.
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("test context attributes set by listen<br>");
    out.print("<br>");

    Dog dog = (Dog) getServletContext().getAttribute("Dog");

    out.println("Dog's breed is " + dog.getBreed());
  }
}
