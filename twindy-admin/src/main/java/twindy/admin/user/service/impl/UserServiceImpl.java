package twindy.admin.user.service.impl;

import org.springframework.stereotype.Service;
import twindy.admin.user.dao.UserDao;
import twindy.admin.user.entity.User;
import twindy.admin.user.service.UserService;

import javax.annotation.Resource;

/**
 * @author senola
 * @time 2017-06-29
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User queryUser(User user) {
        return userDao.queryUser(user);
    }
}
