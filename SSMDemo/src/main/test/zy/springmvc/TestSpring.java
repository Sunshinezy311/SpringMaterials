package zy.springmvc;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import zy.springmvc.dao.AccountDao;
import zy.springmvc.domain.Account;
import zy.springmvc.service.AccountService;

import java.io.IOException;
import java.io.InputStream;

public class TestSpring {
    @Test
    public void runSpringService() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService accountService = (AccountService) context.getBean("accountService");
        //调用方法
        accountService.findAll();
    }

    @Test
    public void testSpringDao() throws IOException {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有的账户信息
        System.out.println(dao.findAll());
        //关闭资源
        session.close();
        in.close();
    }

    @Test
    public void testDaoSaveFunction() throws IOException {
        Account account=new Account();
        account.setMoney(250D);
        account.setName("喷射战士");
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建sqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //保存账户信息
        dao.saveAccount(account);
        //提交结果
        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
