package fun.joyboy.goldfish.service;

import fun.joyboy.goldfish.domain.User;

/**
 * @author ZYOOO
 * @date 2021-10-25 19:46
 */
public interface UserService {
    User login(User user);
    boolean register(User user);
    User findUserByUsername(String username);
}
