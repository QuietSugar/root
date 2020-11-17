package name.xu.main;

import name.xu.model.User;
import name.xu.service.impl.UserServiceImpl;
import name.xu.util.JdbcTemplateFactory;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by xu
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        JdbcTemplateFactory.init();
        UserServiceImpl us = JdbcTemplateFactory.getBean("userServiceImpl", UserServiceImpl.class);
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("测试-pool-%d").daemon(false).build());

        executorService.scheduleWithFixedDelay(() -> {
            System.out.println(Thread.currentThread().getName());

            List<User> users = us.selectAll();
            for (User user : users) {
                LOG.debug("name:{}", user.getName());
            }
        }, 5, 1, TimeUnit.SECONDS);
    }
}
