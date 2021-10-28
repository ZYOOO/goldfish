package fun.joyboy.goldfish.dao;

import fun.joyboy.goldfish.domain.Vocabulary;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-27 16:51
 */
public interface VocabularyDao {
    public boolean add(Vocabulary vocabulary);

    public List<Vocabulary> searchByUidAndDate(int uid, String date);

    public List<Vocabulary> searchByI(int uid);

    public boolean unknown(int vid);

    public boolean changeStatus(int vid);
}
