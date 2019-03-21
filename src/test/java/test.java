import com.model.books;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {

    @Test
    public void test() throws IOException {
        /**
         *  1、获得 SqlSessionFactory
         *  2、获得 SqlSession
         *  3、调用在 mapper 文件中配置的 SQL 语句
         **/
        // 定位核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建 SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取到 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 调用 mapper 中的方法：命名空间 + id
        List<books> booksList = sqlSession.selectList("com/mapper/booksMapper.findAll");

        for (com.model.books books : booksList){
            System.out.println(books);
        }
    }
}
