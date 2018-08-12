package com.charjay.user;


import com.charjay.dal.UserDao;
import com.charjay.user.dto.DebitRequest;
import com.charjay.user.dto.DebitResponse;
import com.charjay.user.dto.UserLoginRequest;
import com.charjay.user.dto.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**

 */
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    UserDao userDao;

    public UserLoginResponse login(UserLoginRequest request) {
        //参数校验
        UserLoginResponse response=new UserLoginResponse();

        response.setCode("100002");
        response.setMemo("登录失败,帐号或密码错误");
        return response;
    }

    public DebitResponse debit(DebitRequest request) {
        DebitResponse response=new DebitResponse();
        userDao.updateUser();
        response.setCode("000000");
        response.setMemo("成功");
        return response;
    }
}
