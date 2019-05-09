package poi.student.domain;

import java.io.Serializable;

/**
 * Created with IDEA
 * author:bigStone
 * Date:2019/5/6
 **/
public class Student implements Serializable {

    private Integer sid;
    private String username;
    private String password;
    private String sclass;//所属班级
    private Integer score;
    private Integer state;
    private String gid; //所属分组

    public Student() {
    }

    public Student(int sid, String username, String password, String sclass, int score) {
        this.sid = sid;
        this.username = username;
        this.password = password;
        this.sclass =sclass;
        this.score = score;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sclass='" + sclass + '\'' +
                ", score=" + score +
                ", state=" + state +
                ", gid='" + gid + '\'' +
                '}';
    }
}
