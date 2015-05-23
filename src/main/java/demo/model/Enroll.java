package demo.model;

import java.io.Serializable;

public class Enroll implements Serializable {

    private Integer id;
    private String sno;
    private String sname;
    private int activityId;

    public Enroll() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getSno() {
        return this.sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String  getSname() {
        return this.sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int  getActivityId() {
        return this.activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "Enroll{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", activityId=" + activityId +
                '}';
    }
}