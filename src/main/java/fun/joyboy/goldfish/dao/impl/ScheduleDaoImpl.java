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
        List<Schedule> list = null;
        try {
            String sql = "select * from tab_schedule where uid = ? order by t_start";
            list = template.query(sql,new BeanPropertyRowMapper<Schedule>(Schedule.class),uid);
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public boolean set(Schedule schedule) {
        try {
            String sql = "insert into tab_schedule(uid,t_start,t_end,dailyMission) values(?,?,?,?)";
            template.update(sql,schedule.getUid(),schedule.getT_start(),schedule.getT_end(),schedule.getDailyMission());
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteBySid(int sid) {
        try{
            String sql = "delete from tab_schedule where sid = ?";
            template.update(sql,sid);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
