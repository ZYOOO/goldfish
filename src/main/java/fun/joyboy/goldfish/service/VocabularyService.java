package fun.joyboy.goldfish.service;

import fun.joyboy.goldfish.domain.Vocabulary;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-27 16:52
 */
public interface VocabularyService {
    public boolean addVocabulary(Vocabulary vocabulary);

    public List<Vocabulary> searchVocabularyByUidAndDate(int uid, String date);

    public List<Vocabulary> searchVocabularyByI(int uid);

    public boolean unknown(int vid);

    public boolean changeStatus(int vid);

    public List<Vocabulary> searchAllVocabularyByUid(int uid);

    public List<Vocabulary> searchAllForgetByUid(int uid);

    public boolean deleteVocabularyByVid(int vid);

    public boolean recoverVocabularyByVid(int vid);
}
