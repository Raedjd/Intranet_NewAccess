package com.nwa.intraservice.utils;

public class ChangePasswordModel {

    private String oldPassword;
    private  String newPassword;

    public ChangePasswordModel() {
    }

    public ChangePasswordModel(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
