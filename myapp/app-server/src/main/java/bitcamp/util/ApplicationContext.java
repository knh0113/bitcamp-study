package bitcamp.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import bitcamp.myapp.config.AppConfig;

public class ApplicationContext {

  // 객체 보관소
  Map<String, Object> beanContainer = new HashMap<>();

  public ApplicationContext(Class<?> configClass) throws Exception {
    Constructor<?> constructor = configClass.getConstructor();

    Object obj = constructor.newInstance();

    Method[] methods = configClass.getDeclaredMethods(); // 해당 클래스에 정의된 메서드 목록만 가져온다
    for (Method m : methods) {
      if (m.getReturnType() == void.class) {
        continue;
      }

      Object returnValue = m.invoke(obj);

      beanContainer.put(m.getName(), returnValue);

      System.out.println(m.getName());
    }
  }

  public Object getBean(String name) {
    return beanContainer.get(name);
  }

  public Object getBeanNames() {
    return beanContainer.keySet().toArray(new String[] {});
  }

  public static void main(String[] args) throws Exception {
    ApplicationContext applicationContext = new ApplicationContext(AppConfig.class);
    System.out.println();
  }

}
