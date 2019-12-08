import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class MapperTest {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }

    @Test
    public void testFindByName() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        SqlSessionFactory factory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession session = factory.openSession();
    }
}
