package bitcamp.myapp.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {


  public String home() throws Exception {
    return "/WEB-INF/jsp/index.jsp";
  }
}
