package com.enter.entercustomerservice.task;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * @author Liquid
 * @类名： ThreadPool
 * @描述：
 * @date 2019/4/17
 */
@Component("threadPool")
public class ThreadPool {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("Thread-pool-%d").build();
    private static ExecutorService singleThreadPool = new ThreadPoolExecutor(20, 100,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static ExecutorService getSingleThreadPool() {
        return singleThreadPool;
    }


}
