package com.whz;
//ORM
//这个类与tb_user表映射
//表字段与类的属性保持一致
public class User {
    private Integer uid;//与tb_user表的uid字段映射
    private String userName;//与tb_user表的userName字段映射
    private String pwd;//与tb_user表的pwd字段映射
    private String tel;//与tb_user表的tel字段映射
    private String address;//与tb_user表的address字段映射

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
