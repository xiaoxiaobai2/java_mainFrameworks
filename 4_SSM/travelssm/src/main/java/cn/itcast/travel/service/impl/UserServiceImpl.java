package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户查询，表现层，注解支持
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public boolean register(User user) {
        //按用户名查找用户
        User user_result = userDao.findByUsername(user.getUsername());
        user.setStatus("N");//设置激活状态为no
        user.setCode(UuidUtil.getUuid());//存储唯一的激活码
        if (user_result==null){
            System.out.println("UserServiceImpl.register");
            userDao.insertUser(user);
            /*
                注册完成之后发送邮件
             */

            //设置邮件内容----跳转到UserController.active.do
            String text="<a href='http://localhost:8080/travelssm/user/active.do?code=" + user.getCode() + "'>激活邮箱</a>";
            System.out.println(text);
            //发送邮件（邮件地址，邮件内容，邮件主题）
            MailUtils.sendMail(user.getEmail(),text,"黑马旅游网，激活邮箱");

            return true;
        }else {
            return false;
        }
    }

    public boolean checkCode(String code) {
        User user = userDao.findByCode(code);
        if (user!=null){
            //查找到用户，证明code存在，正常激活;
            user.setStatus("Y");
            userDao.updateUserStatus(user);
            return true;
        }else {
            return false;
        }
    }

    public User login(User user) {
        //为输入用户名或密码
        if (user.getUsername()==null||user.getPassword()==null){
            System.out.println("未输入用户名或密码");
            return null;
        }
        return userDao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
