package fun.joyboy.goldfish.domain;

/**
 * @author ZYOOO
 * @date 2021-10-25 18:42
 */
public class Schedule {
    private int uid;
    private String t_start;
    private String t_end;
    private String dailyMission;
    private int sid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getT_end() {
        return t_end;
    }

    public void setT_end(String t_end) {
        this.t_end = t_end;
    }

    public String getT_start() {
        return t_start;
    }

    public void setT_start(String t_start) {
        this.t_start = t_start;
    }

    public String getDailyMission() {
        return dailyMission;
    }

    public void setDailyMission(String dailyMission) {
        this.dailyMission = dailyMission;
    }
}
