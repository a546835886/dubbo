package cn.itcast.dubbo;

import cn.itcast.dubbo.pojo.User;
import cn.itcast.dubbo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserServiceTest {
    private UserService userService;//从这里我们可以看出，使用了dubbo后感觉调用服务是在自己的工程一样，但是其实我们是调用的b系统，因为b将服务接口暴露出来了，我们通过访问注册中心的服务接口来获取服务的实现。

    @Before
    public void setUp() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:*.xml");
        this.userService = applicationContext.getBean(UserService.class);
    }

    @Test
    public void testQueryAll() {
        List<User> users = this.userService.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
