import com.zhanghao.service.Impl.ServiceImpl;
import com.zhanghao.service.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        Service service = ac.getBean("service", Service.class);
//        service.saveAccount();
        service.delete(1);
//        service.findTotal();
    }
}
