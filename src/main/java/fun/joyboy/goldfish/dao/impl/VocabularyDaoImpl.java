package fun.joyboy.goldfish.dao.impl;

import fun.joyboy.goldfish.dao.VocabularyDao;
import fun.joyboy.goldfish.domain.Vocabulary;
import fun.joyboy.goldfish.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-27 16:51
 */
public class VocabularyDaoImpl implements VocabularyDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public boolean add(Vocabulary vocabulary) {

        try {
            //添加单词
            String sql1 = "insert into vocabulary(uid,c_date,word,meaning) values(?,?,?,?)";
            //添加复习日期
            String sql2 = "insert into tab_date(uid,r_date) values(?,?)";
            template.update(sql1, vocabulary.getUid(), vocabulary.getC_date(), vocabulary.getWord(), vocabulary.getMeaning());
            template.update(sql2, vocabulary.getUid(),vocabulary.getC_date());
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Vocabulary> searchByUidAndDate(int uid, String date) {
        List<Vocabulary> list = null;
        try {
            String sql = "select * from vocabulary where uid = ? and status = 1 and c_date = ? order by e_count";
            list = template.query(sql, new BeanPropertyRowMapper<Vocabulary>(Vocabulary.class), uid, date);
            Collections.reverse(list);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Vocabulary> searchByI(int uid) {
        List<Vocabulary> list = null;
        try {
            Date d = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Object[] args = new Object[8];
            args[0] = uid;
            args[1] = 1;
            args[2] = df.format(d);
            args[3] = df.format(new Date(d.getTime() - 1 * 24 * 60 * 60 * 1000));
            args[4] = df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000));
            args[5] = df.format(new Date(d.getTime() - 4 * 24 * 60 * 60 * 1000));
            args[6] = df.format(new Date(d.getTime() - 7 * 24 * 60 * 60 * 1000));
            args[7] = df.format(new Date(d.getTime() - 15 * 24 * 60 * 60 * 1000));
            String sql = "select * from vocabulary where uid = ? and status = ? and ( c_date = ? or c_date = ? or c_date = ? or c_date = ? or c_date = ? or c_date = ? ) order by e_count";
            list = template.query(sql, new BeanPropertyRowMapper<Vocabulary>(Vocabulary.class), args);
            Collections.reverse(list);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean unknown(int vid) {
        try {
            String sql = "select e_count from vocabulary where vid = ?";
            int e_count = template.queryForObject(sql, Integer.class, vid);
            sql = "update vocabulary set e_count = ? where vid = ?";
            template.update(sql, ++e_count, vid);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean changeStatus(int vid) {
        try {
            String sql = "update vocabulary set status = 0 where vid = ?";
            template.update(sql, vid);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public List<Vocabulary> searchAllByUid(int uid) {
        List<Vocabulary> list = null;
        try {
            String sql = "select * from vocabulary where uid = ? and status = 1 order by e_count";
            list = template.query(sql, new BeanPropertyRowMapper<Vocabulary>(Vocabulary.class), uid);
            Collections.reverse(list);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Vocabulary> searchAllForgetByUid(int uid) {
        List<Vocabulary> list = null;
        try {
            String sql = "select * from vocabulary where uid = ? and status = 0 ";
            list = template.query(sql, new BeanPropertyRowMapper<Vocabulary>(Vocabulary.class), uid);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean deleteByVid(int vid) {
        try {
            String sql = "delete from vocabulary where vid = ?";
            template.update(sql,vid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean recoverByVid(int vid) {
        try {
            String sql = "update vocabulary set status = 1 where vid = ?";
            template.update(sql, vid);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
