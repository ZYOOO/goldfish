package fun.joyboy.goldfish.service.impl;

import fun.joyboy.goldfish.dao.MissionDao;
import fun.joyboy.goldfish.dao.impl.MissionDaoImpl;
import fun.joyboy.goldfish.domain.Mission;
import fun.joyboy.goldfish.service.MissionService;

import java.rmi.server.UID;
import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-26 15:33
 */
public class MissionServiceImpl implements MissionService {
    private MissionDao missionDao = new MissionDaoImpl();
    @Override
    public List<Mission> findMissionByUid(int uid) {
        return missionDao.findByUid(uid);
    }

    @Override
    public boolean setMission(Mission mission) {
        return missionDao.set(mission);
    }

    @Override
    public boolean deleteMissionByMid(int mid) {
        return missionDao.deleteByMid(mid);
    }
}
