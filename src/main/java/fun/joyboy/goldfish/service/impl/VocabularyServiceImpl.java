package fun.joyboy.goldfish.service.impl;

import fun.joyboy.goldfish.dao.VocabularyDao;
import fun.joyboy.goldfish.dao.impl.VocabularyDaoImpl;
import fun.joyboy.goldfish.domain.Vocabulary;
import fun.joyboy.goldfish.service.VocabularyService;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-27 16:52
 */
public class VocabularyServiceImpl implements VocabularyService {
    private VocabularyDao vocabularyDao = new VocabularyDaoImpl();

    @Override
    public boolean addVocabulary(Vocabulary vocabulary) {
        return vocabularyDao.add(vocabulary);
    }

    @Override
    public List<Vocabulary> searchVocabularyByUidAndDate(int uid, String date) {
        return vocabularyDao.searchByUidAndDate(uid,date);
    }

    @Override
    public List<Vocabulary> searchVocabularyByI(int uid) {
        return vocabularyDao.searchByI(uid);
    }

    @Override
    public boolean unknown(int vid) {
        return vocabularyDao.unknown(vid);
    }

    @Override
    public boolean changeStatus(int vid) {
        return vocabularyDao.changeStatus(vid);
    }

    @Override
    public List<Vocabulary> searchAllVocabularyByUid(int uid) {
        return vocabularyDao.searchAllByUid(uid);
    }

    @Override
    public List<Vocabulary> searchAllForgetByUid(int uid) {
        return vocabularyDao.searchAllForgetByUid(uid);
    }

    @Override
    public boolean deleteVocabularyByVid(int vid) {
        return vocabularyDao.deleteByVid(vid);
    }

    @Override
    public boolean recoverVocabularyByVid(int vid) {
        return vocabularyDao.recoverByVid(vid);
    }

}
