package com.enter.service.aop;

import com.enter.service.result.ResultBean;
import com.enter.util.exception.CheckedException;
import com.enter.util.exception.UnCheckedException;
import com.enter.util.exception.UserException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
@Slf4j
public class LogAndExceptionAOP {

    @Pointcut("execution(public com.enter.service.result.ResultBean *(..))")
    public void resultBean() {
    }

    @Around("resultBean()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
        long startTime = System.currentTimeMillis();
        ResultBean<?> result;
        try {
            result = (ResultBean<?>) pjp.proceed();
            log.info("[当前线程: {}]   [切点: {}]  [方法运行时间: {}ms]",Thread.currentThread().getName(),pjp.getSignature() ,(System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }

        return result;
    }

    private ResultBean<?> handlerException(ProceedingJoinPoint pjp, Throwable e) {
        ResultBean<?> result = new ResultBean();
        // 已知异常 code=1,2,3
        if (e instanceof UserException) {
            result.setMsg(e.toString());
            result.setCode(ResultBean.USER_FAIL);
            log.warn("发生用户异常！{ 当前线程: {}] [切点: {}][异常信息: {} }", Thread.currentThread().getName(), pjp.getSignature(), e.toString());
        } else if (e instanceof UnCheckedException) {
            result.setMsg(e.toString());
            result.setCode(ResultBean.UNCHECKED_EXCEPTION_FAIL);
            log.error("发生不受检异常！{ 当前线程: {}] [切点: {}][异常信息: {} }", Thread.currentThread().getName(), pjp.getSignature(), e.toString());
        } else if (e instanceof CheckedException) {
            log.warn("发生受检异常！{ 当前线程: {}] [切点: {}][异常信息: {} }", Thread.currentThread().getName(), pjp.getSignature(), e.toString());
            result.setMsg(e.toString());
            result.setCode(ResultBean.CHECKED_EXCEPTION_FAIL);
        } else {
            log.error("发生未知异常！{ 当前线程: {}]  [切点: {}]  [异常信息: {}-{} }", Thread.currentThread().getName(), pjp.getSignature(), e.toString(), e.getLocalizedMessage());
            // 未知的异常，应该格外注意，可以发送邮件通知等 code=4
            result.setMsg(e.toString());
            result.setCode(ResultBean.UNKNOWN_EXCEPTION_FAIL);
        }

        return result;
    }
}
