package fun.joyboy.goldfish.service.impl;

import fun.joyboy.goldfish.dao.UserDao;
import fun.joyboy.goldfish.dao.impl.UserDaoImpl;
import fun.joyboy.goldfish.domain.User;
import fun.joyboy.goldfish.service.UserService;

/**
 * @author ZYOOO
 * @date 2021-10-25 19:46
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.findByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean register(User user) {
        return userDao.save(user);
    }
}
