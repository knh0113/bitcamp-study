package bitcamp.util;

public class MenuGroup extends Menu {

  ArrayList childs;

  public MenuGroup(String title) {
    super(title);
    childs = new ArrayList();

  }

  public void addMenu(Menu menu) {
    this.childs.add(menu);
  }
}
