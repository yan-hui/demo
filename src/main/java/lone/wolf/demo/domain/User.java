package lone.wolf.demo.domain;

import java.util.Date;

/**
 * @ClassName User
 * @Description
 * @Author hechunhui
 * @Date 2018/7/2 18:04
 */
public class User {
    private String userid;
    private String username;
    private String gender;
    private Date createtime;
    private String address;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", createtime=" + createtime +
                ", address='" + address + '\'' +
                '}';
    }
}
