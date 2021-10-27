package fun.joyboy.goldfish.domain;

import java.util.List;

/**
 * @author ZYOOO
 * @date 2021-10-25 18:43
 */
public class Mission {
    private int uid;
    private String mission;
    private int mid;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }
}
