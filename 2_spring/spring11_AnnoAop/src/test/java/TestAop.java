//import com.zhanghao.config.SpringConfiguration;
import com.zhanghao.config.SpringConfiguration;
import com.zhanghao.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        Service service = ac.getBean("service", Service.class);
//        service.saveAccount();
        service.delete(1);
//        service.findTotal();
    }
}
