package name.xu.dao;

import name.xu.model.User;

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
