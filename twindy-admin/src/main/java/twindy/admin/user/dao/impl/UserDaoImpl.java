package twindy.admin.user.dao.impl;

import org.springframework.stereotype.Repository;
import twindy.admin.user.dao.UserDao;
import twindy.admin.user.entity.User;
import twindy.common.db.BaseDao;

/**
 * @author senola
 * @time 2017-06-29
 */

@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

    @Override
    public User queryUser(User user) {
        return getSqlSession().selectOne("user.queryUser", user);
    }

    @Override
    public int addUser(User user) {
        return 0;
    }
}
