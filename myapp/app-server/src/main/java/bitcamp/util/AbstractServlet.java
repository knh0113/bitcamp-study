package bitcamp.util;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public abstract class AbstractServlet implements Servlet {

  ServletConfig config;

  @Override
  private void init(ServletConfig config) throws ServletException {
    this.config = config;
  }
}
