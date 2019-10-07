package com.enter.service.context.token;

import com.enter.util.exception.CheckedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Liquid
 * @类名： TokenContext
 * @描述：
 * @date 2019/6/17
 */
@Component
public class TokenContext {

    @Autowired
    private final Map<String, TokenStorager> strategyMap = new ConcurrentHashMap<>();

    public void pay(Token  token, String beanName) throws CheckedException {
        this.strategyMap.get(beanName).tokenStorage(token);
    }
}
