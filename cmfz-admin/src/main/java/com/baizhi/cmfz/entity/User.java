package com.baizhi.cmfz.entity;

public class User {
    private String userId;
    private String UserName;
    private String userBuddhishName;
    private String userPassword;
    private String userSex;
    private String userPhoto;
    private String userAddress;
    private String userPhone;
    private String userSignature;
    private boolean userStatus;

    public User() {
    }

    public User(String userId, String userName, String userBuddhishName, String userPassword, String userSex, String userPhoto, String userAddress, String userPhone, String userSignature, boolean userStatus) {
        this.userId = userId;
        UserName = userName;
        this.userBuddhishName = userBuddhishName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userPhoto = userPhoto;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userSignature = userSignature;
        this.userStatus = userStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserBuddhishName() {
        return userBuddhishName;
    }

    public void setUserBuddhishName(String userBuddhishName) {
        this.userBuddhishName = userBuddhishName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", UserName='" + UserName + '\'' +
                ", userBuddhishName='" + userBuddhishName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
