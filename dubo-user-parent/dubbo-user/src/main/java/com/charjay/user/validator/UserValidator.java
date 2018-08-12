package com.charjay.user.validator;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.charjay.user.dto.UserLoginRequest;


public class UserValidator {

    public static boolean checkUserLoginRequest(UserLoginRequest request) {
        if (StringUtils.isEmpty(request.getName()) || StringUtils.isEmpty(request.getPassword())) {
            return false;
        }
        return true;
    }
}
