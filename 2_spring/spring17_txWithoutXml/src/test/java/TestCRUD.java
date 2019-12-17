import com.zhanghao.config.SpringConfiguration;
import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestCRUD {

    @Autowired
    private AccountService accountService;
    @Test
    public void testFindAll(){
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void testTransaction(){
        accountService.transaction("bbb","aaa",100);
    }
}
