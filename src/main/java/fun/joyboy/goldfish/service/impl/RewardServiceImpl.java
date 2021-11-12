package fun.joyboy.goldfish.service.impl;

import fun.joyboy.goldfish.dao.RewardDao;
import fun.joyboy.goldfish.dao.impl.RewardDaoImpl;
import fun.joyboy.goldfish.service.RewardService;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-27 19:38
 */
public class RewardServiceImpl implements RewardService {
    private RewardDao rewardDao = new RewardDaoImpl();
    @Override
    public List<String> findRewardByUid(int uid) {
        return rewardDao.findByUid(uid);
    }

    @Override
    public void addRewardByUid(int uid, String date) {
        rewardDao.addByUid(uid,date);
    }
}
