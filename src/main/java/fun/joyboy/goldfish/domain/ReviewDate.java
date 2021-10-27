package fun.joyboy.goldfish.domain;

/**
 * @author ZYOOO
 * @date 2021-10-25 18:45
 */
public class ReviewDate {
    private int uid;
    private String c_date;
    private int did;

    public String getC_date() {
        return c_date;
    }

    public void setC_date(String c_date) {
        this.c_date = c_date;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
