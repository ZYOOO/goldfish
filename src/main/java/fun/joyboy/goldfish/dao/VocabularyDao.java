package fun.joyboy.goldfish.dao;

import fun.joyboy.goldfish.domain.Vocabulary;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-27 16:51
 */
public interface VocabularyDao {
    public boolean add(Vocabulary vocabulary);

    List<Vocabulary> searchByUidAndDate(int uid, String date);

    List<Vocabulary> searchByI(int uid);
}
