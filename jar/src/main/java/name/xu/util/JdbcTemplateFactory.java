package name.xu.util;

import name.xu.service.UserService;
import name.xu.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplateFactory
 *
 * @author HuoXu
 */
public class JdbcTemplateFactory {
    private static final Logger LOG = LoggerFactory.getLogger(JdbcTemplateFactory.class);
    private static final ApplicationContext APPLICATIONCONTEXT;
    private static JdbcTemplate jdbcTemplate;

    protected JdbcTemplateFactory() {
    }

    static {
        LOG.info("initializing spring ApplicationContext...");

        APPLICATIONCONTEXT = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        jdbcTemplate = APPLICATIONCONTEXT.getBean("jdbcTemplate", JdbcTemplate.class);
    }

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        return APPLICATIONCONTEXT.getBean(beanName, clazz);
    }

    /**
     * 用户 service
     *
     * @return UserService
     */
    public static UserService getUserService() {
        return getBean("UserServiceImpl", UserServiceImpl.class);
    }

    public static void init() {
        // empty body
    }
}
