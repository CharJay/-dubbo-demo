package com.charjay.test;

import com.alibaba.dubbo.rpc.RpcContext;
import com.charjay.order.DoOrderRequest;
import com.charjay.order.DoOrderResponse;
import com.charjay.order.IOrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Hello world!
 */
public class ConsumeTest {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");

        //用户下单过程
        IOrderService services = (IOrderService) context.getBean("orderService");
        DoOrderRequest request = new DoOrderRequest();
        request.setName("charjay");
        //直接调用
//        DoOrderResponse response=services.doOrder(request);
//        System.out.println(response);

        //异步调用
        DoOrderResponse response1 = services.doOrder(request);
        System.out.println("立即返回的为null：" + response1);
        Future<DoOrderResponse> response2 = RpcContext.getContext().getFuture();
        System.out.println("1111111111");
        DoOrderResponse ret = response2.get();
        System.out.println("有值的：" + ret);

        System.in.read();

    }
}
