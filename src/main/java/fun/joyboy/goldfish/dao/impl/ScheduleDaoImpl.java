package fun.joyboy.goldfish.dao.impl;

import fun.joyboy.goldfish.dao.ScheduleDao;
import fun.joyboy.goldfish.domain.Schedule;
import fun.joyboy.goldfish.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-26 22:52
 */
public class ScheduleDaoImpl implements ScheduleDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<Schedule> findByUid(int uid) {
        String sql = "select * from tab_schedule where uid = ? order by t_start";
        return template.query(sql,new BeanPropertyRowMapper<Schedule>(Schedule.class),uid);
    }

    @Override
    public boolean set(Schedule schedule) {
        String sql = "insert into tab_schedule(uid,t_start,t_end,dailyMission) values(?,?,?,?)";
        template.update(sql,schedule.getUid(),schedule.getT_start(),schedule.getT_end(),schedule.getDailyMission());
        return true;
    }

    @Override
    public boolean deleteBySid(int sid) {
        String sql = "delete from tab_schedule where sid = ?";
        template.update(sql,sid);
        return true;
    }
}
