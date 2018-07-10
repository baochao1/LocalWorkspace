package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeerSelect extends HttpServlet {
  /**
   * docx.
   */
  private static final long serialVersionUID = 1L;

  /*
     * (non-Javadoc)
     * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
     *  HttpServletRequest,javax.servlet.http.HttpServletResponse)
     */
  @Override
  public void doPost(final HttpServletRequest request,
                    final HttpServletResponse response)
                    throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.println("Beer Selection Advice<br>");
    String c = request.getParameter("color");
    out.println("<br>Got ber color " + c);
  }

}
