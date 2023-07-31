package bitcamp.myapp.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.util.Bean;
import bitcamp.util.SqlSessionFactoryProxy;

public class AppConfig {

  @Bean
  public SqlSessionFactory createSqlSessionFactory() throws Exception {
    return new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder()
        .build(Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml")));
  }
}
