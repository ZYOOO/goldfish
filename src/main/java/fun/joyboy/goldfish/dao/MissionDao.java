package fun.joyboy.goldfish.dao;

import fun.joyboy.goldfish.domain.Mission;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-26 15:35
 */
public interface MissionDao {
    public List<Mission> findByUid(int uid);

    public boolean set(Mission mission);
    public boolean deleteByMid(int mid);

}
