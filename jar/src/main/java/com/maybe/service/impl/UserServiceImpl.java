package com.maybe.service.impl;

import com.maybe.dao.UserDao;
import com.maybe.model.User;
import com.maybe.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
