package com.enter.service.context.token.redis;

import com.enter.service.context.token.Token;
import com.enter.service.context.token.TokenStorager;
import com.enter.service.nosql.CacheContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Liquid
 * @类名： RedisTokenStorager
 * @描述：
 * @date 2019/6/17
 */
@Component
public class RedisTokenStorager implements TokenStorager {

    @Autowired
    private CacheContext cacheContext;

    @Override
    public void tokenStorage(Token token) {
        cacheContext.setStringWithTimeOut(token.getTokenId(), token.getTokenName(), token.getExpired());

    }
}
