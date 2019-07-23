package com.terminator.smart.parking.entity;
/**
*@Description  用户实体类
*@Author 杨志豪
*@DateTime 2019/7/23 0023 11:43
*/
public class User {
    private int userId;
    private String username;
    private String password;
    private String phone;
    private String licenseNumber;
    private String email;
    private int verify;

    public User() {
    }

    public User(int userId, String username, String password, String phone, String licenseNumber, String email, int verify) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
        this.email = email;
        this.verify = verify;

    }
    public User(String username, String password, String phone, String licenseNumber, String email, int verify) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
        this.email = email;
        this.verify = verify;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }



    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", email='" + email + '\'' +
                ", verify=" + verify +
                '}';
    }
}
