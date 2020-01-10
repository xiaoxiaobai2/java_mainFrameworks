package cn.itcast.travel.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 收藏实体类
 */
public class Favorite implements Serializable {
    private Integer rid;//旅游线路对象
    private Date date;//收藏时间
    private Integer uid;//所属用户

    /**
     * 无参构造方法
     */
    public Favorite() {
    }

    /**
     * 有参构造方法
     * @param rid
     * @param date
     * @param uid
     */
    public Favorite(Integer rid, Date date, Integer uid) {
            this.rid = rid;
            this.date = date;
            this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "rid=" + rid +
                ", date=" + date +
                ", uid=" + uid +
                '}';
    }
}
