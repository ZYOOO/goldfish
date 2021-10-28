package fun.joyboy.goldfish.dao.impl;

import fun.joyboy.goldfish.dao.VocabularyDao;
import fun.joyboy.goldfish.domain.Vocabulary;
import fun.joyboy.goldfish.util.JDBCUtils;
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
        //添加单词
        String sql1 = "insert into vocabulary(uid,c_date,word,meaning) values(?,?,?,?)";
        //添加复习日期
        String sql2 = "insert into tab_date(uid,r_date) values(?,?)";
        template.update(sql1,vocabulary.getUid(),vocabulary.getC_date(),vocabulary.getWord(),vocabulary.getMeaning());
        template.update(sql2,vocabulary.getUid(),vocabulary.getC_date());
        return true;
    }

    @Override
    public List<Vocabulary> searchByUidAndDate(int uid, String date) {
        String sql = "select * from vocabulary where uid = ? and status = 1 and c_date = ? order by e_count";
        List<Vocabulary> list = template.query(sql,new BeanPropertyRowMapper<Vocabulary>(Vocabulary.class),uid,date);
        Collections.reverse(list);
        return list;
    }

    @Override
    public List<Vocabulary> searchByI(int uid) {
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Object[] args = new Object[7];
        args[0] = uid;
        args[1] = df.format(d);
        args[2] = df.format(new Date(d.getTime() - 1 * 24 * 60 * 60 * 1000));
        args[3] = df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000));
        args[4] = df.format(new Date(d.getTime() - 4 * 24 * 60 * 60 * 1000));
        args[5] = df.format(new Date(d.getTime() - 7 * 24 * 60 * 60 * 1000));
        args[6] = df.format(new Date(d.getTime() - 15 * 24 * 60 * 60 * 1000));
        String sql = "select * from vocabulary where uid = ? and status = 1 and c_date = ? or c_date = ? or c_date = ? or c_date = ? or c_date = ? or c_date = ? order by e_count";
        List<Vocabulary> list = template.query(sql,new BeanPropertyRowMapper<Vocabulary>(Vocabulary.class),args);
        Collections.reverse(list);
        System.out.println(list);
        return list;
    }

    @Override
    public boolean unknown(int vid) {
        String sql = "select e_count from vocabulary where vid = ?";
        int e_count = template.queryForObject(sql,Integer.class,vid);
        sql = "update vocabulary set e_count = ? where vid = ?";
        template.update(sql,++e_count,vid);
        return true;
    }

    @Override
    public boolean changeStatus(int vid) {
        String sql = "update vocabulary set status = 0 where vid = ?";
        template.update(sql,vid);
        return true;
    }
}
