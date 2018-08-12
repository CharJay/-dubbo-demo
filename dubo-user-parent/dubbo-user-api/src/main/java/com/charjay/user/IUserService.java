package com.charjay.user;


import com.charjay.user.dto.DebitRequest;
import com.charjay.user.dto.DebitResponse;
import com.charjay.user.dto.UserLoginRequest;
import com.charjay.user.dto.UserLoginResponse;

/**

 */
public interface IUserService {

    /**
     * 登录
     * @param request
     * @return
     */
    UserLoginResponse login(UserLoginRequest request);

    /*
     * 更新用户余额
     */
    DebitResponse debit(DebitRequest request);
}
