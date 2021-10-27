package fun.joyboy.goldfish.dao;

import fun.joyboy.goldfish.domain.User;

/**
 * @author ZYOOO
 * @date 2021-10-25 19:44
 */
public interface UserDao {
    public User findByUsername(String username);

    public boolean save (User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
