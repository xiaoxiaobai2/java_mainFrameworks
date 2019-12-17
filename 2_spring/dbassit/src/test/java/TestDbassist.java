import com.zhanghao.dao.AccountDao;
import com.zhanghao.dao.impl.AccountDaoImpl;
import com.zhanghao.domain.Account;
import org.junit.Test;

import java.util.List;

public class TestDbassist {
    private AccountDao accountDao = new AccountDaoImpl();
    @Test
    public void testInsert(){
        Account account = new Account();
        account.setName("zhangsan");
        account.setMoney(10000);
        accountDao.insert(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setName("update");
        account.setMoney(10000);
        account.setId(4);
        accountDao.update(account);
    }
    @Test
    public void testDelete(){
        accountDao.delete(4);
    }
    @Test
    public void testFindAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("account = " + account);
        }
    }
    @Test
    public void testFindById(){
        Account account = accountDao.findById(3);
        System.out.println(account);
    }
}
