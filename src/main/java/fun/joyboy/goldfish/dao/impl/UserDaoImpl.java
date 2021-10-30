package fun.joyboy.goldfish.dao.impl;

import fun.joyboy.goldfish.dao.UserDao;
import fun.joyboy.goldfish.domain.User;
import fun.joyboy.goldfish.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author ZYOOO
 * @date 2021-10-25 19:45
 */
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User findByUsername(String username) {
        User user = null;
        try{
            String sql = "select * from user where username = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username);
        }catch (Exception e){
            System.out.println("未查找到此用户");
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        try {
            String sql = "insert into user(username,password,name,birthday,gender,telephone,email) values(?,?,?,?,?,?,?)";
            template.update(sql,user.getUsername(),user.getPassword(),user.getName(),user.getBirthday(),
                    user.getGender(),user.getTelephone(),user.getEmail());
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public User findByCode(String code) {
        return null;
    }

    @Override
    public void updateStatus(User user) {

    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = null;
        try{
            String sql = "select * from user where username = ? and password = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        }catch (Exception e){
            System.out.println("用户名或密码错误");
        }
        return user;
    }
}
