package com.maybe.dao;

import com.maybe.model.User;

import java.util.List;

/**
 * @author HuoXu
 */
public interface UserDao {
    /**
     * 查询所有
     *
     * @return List
     */
    List<User> selectAll();

}
