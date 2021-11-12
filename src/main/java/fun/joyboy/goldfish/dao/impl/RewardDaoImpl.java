package fun.joyboy.goldfish.dao.impl;

import fun.joyboy.goldfish.dao.RewardDao;
import fun.joyboy.goldfish.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ZYOOO
 * @date 2021-10-27 19:38
 */
public class RewardDaoImpl implements RewardDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<String> findByUid(int uid) {
        List<String> list = new ArrayList<String>();
        try {
            String sql = "select distinct r_date from tab_date where uid = ?";
            List<Map<String, Object>> list_map;
            list_map = template.queryForList(sql,uid);
            for (Map<String, Object> map:list_map) {
                list.add((String) map.get("r_date"));
            }
            Collections.reverse(list);
        }catch (Exception e){

        }
        return list;

    }

    @Override
    public void addByUid(int uid, String date) {
        try {
            String sql1 = "SELECT COUNT(*) FROM tab_date WHERE uid = ? AND r_date = ?";
            int count = template.queryForObject(sql1,Integer.class,uid,date);
            if(count > 0){
                return;
            }
            //添加复习日期
            String sql2 = "insert into tab_date(uid,r_date) values(?,?)";
            template.update(sql2, uid,date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
