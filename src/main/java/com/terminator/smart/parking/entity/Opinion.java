package com.terminator.smart.parking.entity;

import java.util.Date;

/**
*@Description 意见实体类
*@Author 方泽谋
*@DateTime 2019/7/22 19:57
*/
public class Opinion {
    private int opinionId;
    private String opinionTitle;
    private String opinionBody;
    private String opinionEmail;
    private Date opinionTime;
    private int opinionFlag;

    public Opinion() {
    }

    public Opinion(int opinionId, String opinionTitle, String opinionBody, String opinionEmail, Date opinionTime, int opinionFlag) {
        this.opinionId = opinionId;
        this.opinionTitle = opinionTitle;
        this.opinionBody = opinionBody;
        this.opinionEmail = opinionEmail;
        this.opinionTime = opinionTime;
        this.opinionFlag = opinionFlag;
    }

    public int getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(int opinionId) {
        this.opinionId = opinionId;
    }

    public String getOpinionTitle() {
        return opinionTitle;
    }

    public void setOpinionTitle(String opinionTitle) {
        this.opinionTitle = opinionTitle;
    }

    public String getOpinionBody() {
        return opinionBody;
    }

    public void setOpinionBody(String opinionBody) {
        this.opinionBody = opinionBody;
    }

    public String getOpinionEmail() {
        return opinionEmail;
    }

    public void setOpinionEmail(String opinionEmail) {
        this.opinionEmail = opinionEmail;
    }

    public Date getOpinionTime() {
        return opinionTime;
    }

    public void setOpinionTime(Date opinionTime) {
        this.opinionTime = opinionTime;
    }

    public int getOpinionFlag() {
        return opinionFlag;
    }

    public void setOpinionFlag(int opinionFlag) {
        this.opinionFlag = opinionFlag;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "opinionId=" + opinionId +
                ", opinionTitle='" + opinionTitle + '\'' +
                ", opinionBody='" + opinionBody + '\'' +
                ", opinionEmail=" + opinionEmail +
                ", opinionTime=" + opinionTime +
                ", opinionFlag=" + opinionFlag +
                '}';
    }
}
