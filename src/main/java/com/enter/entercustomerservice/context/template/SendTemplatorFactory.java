package com.enter.entercustomerservice.context.template;

/**
 * Created by Administrator on 2019/9/30.
 */
public interface SendTemplatorFactory {
    SendTemplator createSendTemplator(String beanName);
}