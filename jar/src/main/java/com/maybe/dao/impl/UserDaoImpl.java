package com.maybe.dao.impl;

import com.maybe.dao.UserDao;
import com.maybe.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author HuoXu
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询所有
     */
    @Override
    public List<User> selectAll() {
        try {
            // 使用JdbcTemplate访问数据库
            String sql = "SELECT name,introduction FROM user";
            LOG.debug("execute sql:{}", sql);
            return jdbcTemplate.query(sql, (rs, i) -> {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setIntroduction(rs.getString("introduction"));
                return user;
            });
        } catch (InvalidResultSetAccessException e) {
            throw new RuntimeException(e);
        } catch (DataAccessException e) {
            SQLException exception = (SQLException) e.getCause();
            // 通过exception获取ErrorCode、Message等信息
            LOG.error(exception.getMessage());
        }

        return null;

    }
}
