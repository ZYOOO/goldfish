package fun.joyboy.goldfish.service;

import fun.joyboy.goldfish.domain.Mission;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-26 15:33
 */
public interface MissionService {
    public List<Mission> findMissionByUid(int uid);
    public boolean setMission(Mission mission);
    public boolean deleteMissionByMid(int mid);
}
