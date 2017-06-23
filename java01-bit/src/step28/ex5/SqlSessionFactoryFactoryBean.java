package step28.ex5;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.FactoryBean;

public class SqlSessionFactoryFactoryBean implements FactoryBean {
  String configLocation;
  
  public void setConfigLocation(String configLocation) {
    this.configLocation = configLocation;
  }

  @Override
  public Object getObject() throws Exception {
    InputStream inputStream = Resources.getResourceAsStream(configLocation);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    return sqlSessionFactory;
  }

  @Override
  public Class getObjectType() {
    return SqlSessionFactory.class;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

}
