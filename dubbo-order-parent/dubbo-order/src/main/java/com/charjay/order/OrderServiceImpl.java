package com.charjay.order;


import com.charjay.dal.OrderDao;
import com.charjay.user.IUserService;
import com.charjay.user.dto.DebitRequest;
import com.charjay.user.dto.DebitResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**

 */
@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    JtaTransactionManager springTransactionManager;

    @Autowired
    OrderDao orderDao;

    @Autowired
    IUserService userService;

    public DoOrderResponse doOrder(DoOrderRequest request) {
        DoOrderResponse response=new DoOrderResponse();
        //order下单后调用user更新余额
        UserTransaction userTransaction=springTransactionManager.getUserTransaction();
        try {
            userTransaction.begin();
            orderDao.insertOrder();
            DebitResponse response1 = userService.debit(new DebitRequest());
            System.out.println(response1);
            userTransaction.commit();
        }catch(Exception e){
            try {
                userTransaction.rollback();
            } catch (SystemException e1) {
                e1.printStackTrace();
            }
        }
        response.setCode("000000");
        return response;
    }
}
