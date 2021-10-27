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

}
