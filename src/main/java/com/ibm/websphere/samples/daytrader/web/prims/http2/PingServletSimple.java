package com.ibm.websphere.samples.daytrader.web.prims.http2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PingServletHttpSimple", urlPatterns = { "/PingServletHttpSimple" })
public class PingServletSimple extends HttpServlet {

  private static final long serialVersionUID = -1687383294950455998L;
  private static String initTime;
  private static int hitCount;
    
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    try(PrintWriter respWriter = resp.getWriter();){
      hitCount++;
      //System.out.println("Sending hit count: " + hitCount);
      respWriter.write("<html><head><title>Ping Servlet HTTP/2</title></head>"
          + "<body><HR><BR><FONT size=\"+2\" color=\"#000066\">Ping Servlet HTTP/2<BR></FONT><FONT size=\"+1\" color=\"#000066\">Init time : " + initTime
          + "<BR><BR></FONT>  <B>Hit Count: " + hitCount + "</B><br>" +
          "<img src='images/graph.gif'>" + 
          "</body></html>");
    }
  }
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    initTime = new java.util.Date().toString();
    hitCount = 0;
  }
}
