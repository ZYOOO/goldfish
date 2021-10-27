package fun.joyboy.goldfish.service.impl;

import fun.joyboy.goldfish.dao.ScheduleDao;
import fun.joyboy.goldfish.dao.impl.ScheduleDaoImpl;
import fun.joyboy.goldfish.domain.Schedule;
import fun.joyboy.goldfish.service.ScheduleService;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-26 22:52
 */
public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleDao scheduleDao = new ScheduleDaoImpl();

    @Override
    public List<Schedule> findScheduleByUid(int uid) {
        return scheduleDao.findByUid(uid);
    }

    @Override
    public boolean setSchedule(Schedule schedule) {
        return scheduleDao.set(schedule);
    }

    @Override
    public boolean deleteScheduleBySid(int sid) {
        return scheduleDao.deleteBySid(sid);
    }
}
