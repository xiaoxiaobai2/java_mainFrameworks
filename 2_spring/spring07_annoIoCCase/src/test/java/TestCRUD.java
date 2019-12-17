import com.zhanghao.domain.Account;
import com.zhanghao.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCRUD {
    private AccountService accountService;
    @Before
    public void before(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        accountService = applicationContext.getBean("accountService", AccountService.class);
    }


    @Test
    public void testFindAll(){
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void testDelete(){
        accountService.deleteAccount(1);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(2);
        account.setName("update");
        account.setMoney(100000);
        accountService.updateAccount(account);
    }

    @Test
    public void test(){
        Account account = accountService.findAccountById(3);
        System.out.println("account = " + account);
    }
}
