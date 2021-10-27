package fun.joyboy.goldfish.domain;

import java.util.Date;

/**
 * @author ZYOOO
 * @date 2021-10-25 18:46
 */
public class Vocabulary {
    private int uid;
    private String c_date;
    private String word;
    private String meaning;
    private int status;
    private int e_count;
    private int vid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getC_date() {
        return c_date;
    }

    public void setC_date(String c_date) {
        this.c_date = c_date;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getE_count() {
        return e_count;
    }

    public void setE_count(int e_count) {
        this.e_count = e_count;
    }

    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
    }
}
