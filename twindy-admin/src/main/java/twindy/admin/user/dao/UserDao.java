package twindy.admin.user.dao;


import twindy.admin.user.entity.User;

public interface UserDao {
    User queryUser(User user);
    int addUser(User user);
}
