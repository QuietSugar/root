package name.xu.service.impl;

import name.xu.dao.UserDao;
import name.xu.model.User;
import name.xu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HuoXu
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserDao userDao;


    /**
     * 查询所有
     */
//    @SuppressWarnings(value = "Duplicates")
//    @Transactional(rollbackFor = {Exception.class})
    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }


    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
