package fun.joyboy.goldfish.service;

import fun.joyboy.goldfish.domain.Schedule;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-26 22:52
 */
public interface ScheduleService {
    public List<Schedule> findScheduleByUid (int uid);
    public boolean setSchedule(Schedule schedule);
    public boolean deleteScheduleBySid(int sid);
}
