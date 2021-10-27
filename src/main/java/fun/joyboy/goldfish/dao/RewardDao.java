package fun.joyboy.goldfish.dao;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-27 19:38
 */
public interface RewardDao {
    public List<String> findByUid(int uid);
}
