package fun.joyboy.goldfish.dao.impl;

import fun.joyboy.goldfish.dao.MissionDao;
import fun.joyboy.goldfish.domain.Mission;
import fun.joyboy.goldfish.domain.User;
import fun.joyboy.goldfish.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZYOOO
 * @date 2021-10-26 15:35
 */
public class MissionDaoImpl implements MissionDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Mission> findByUid(int uid) {
        List<Mission> list = null;
        try{
            String sql = "select * from tab_missions where uid = ? order by mid";
            list = template.query(sql,new BeanPropertyRowMapper<Mission>(Mission.class),uid);
        }catch (Exception e){
            System.out.println("findMissionsByIdException");
        }
        return list;
    }

    @Override
    public boolean set(Mission mission) {
        String sql = "insert into tab_missions(uid,mission) values(?,?)";
        template.update(sql,mission.getUid(),mission.getMission());
        return true;
    }

    @Override
    public boolean deleteByMid(int mid) {
        String sql = "delete from tab_missions where mid = ?";
        template.update(sql,mid);
        return true;
    }
}
