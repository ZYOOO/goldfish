package fun.joyboy.goldfish.dao;

import fun.joyboy.goldfish.domain.Mission;
import fun.joyboy.goldfish.domain.Schedule;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-26 22:52
 */
public interface ScheduleDao {
    public List<Schedule> findByUid(int uid);
    public boolean set (Schedule schedule);
    public boolean deleteBySid(int sid);
}
