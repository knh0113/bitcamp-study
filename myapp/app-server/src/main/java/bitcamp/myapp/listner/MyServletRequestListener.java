package bitcamp.myapp.listner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import bitcamp.myapp.handler.InitServlet;
import bitcamp.util.SqlSessionFactoryProxy;

// 요청이나 응답을 수행했을 때 서블릿 컨테이너로부터 알림을 받는 옵저버 객
@WebListener
public class MyServletRequestListener implements ServletRequestListener {

  public MyServletRequestListener() {
    System.out.println("dfsdf");
  }

  @Override
  public void requestDestroyed(ServletRequestEvent sre) {
    ((SqlSessionFactoryProxy) InitServlet.sqlSessionFactory).clean();
  }
}
