package cn.gson.linyun.model.pojos.recruit.vo;

import java.sql.Timestamp;

public class RecruitInterviewnoticeVO {
    private Integer interviewnoticeId;
    private String interviewnoticeName;
    private Timestamp interviewnoticeIntime;
    private String interviewnoticeDidian;
    private String interviewnoticeTel;
    private Timestamp interviewnoticeTime;


    @Override
    public String toString() {
        return "RecruitInterviewnoticeVO{" +
                "interviewnoticeId=" + interviewnoticeId +
                ", interviewnoticeName='" + interviewnoticeName + '\'' +
                ", interviewnoticeIntime=" + interviewnoticeIntime +
                ", interviewnoticeDidian='" + interviewnoticeDidian + '\'' +
                ", interviewnoticeTel='" + interviewnoticeTel + '\'' +
                ", interviewnoticeTime=" + interviewnoticeTime +
                '}';
    }

    public Integer getInterviewnoticeId() {
        return interviewnoticeId;
    }

    public void setInterviewnoticeId(Integer interviewnoticeId) {
        this.interviewnoticeId = interviewnoticeId;
    }

    public String getInterviewnoticeName() {
        return interviewnoticeName;
    }

    public void setInterviewnoticeName(String interviewnoticeName) {
        this.interviewnoticeName = interviewnoticeName;
    }

    public Timestamp getInterviewnoticeIntime() {
        return interviewnoticeIntime;
    }

    public void setInterviewnoticeIntime(Timestamp interviewnoticeIntime) {
        this.interviewnoticeIntime = interviewnoticeIntime;
    }

    public String getInterviewnoticeDidian() {
        return interviewnoticeDidian;
    }

    public void setInterviewnoticeDidian(String interviewnoticeDidian) {
        this.interviewnoticeDidian = interviewnoticeDidian;
    }

    public String getInterviewnoticeTel() {
        return interviewnoticeTel;
    }

    public void setInterviewnoticeTel(String interviewnoticeTel) {
        this.interviewnoticeTel = interviewnoticeTel;
    }

    public Timestamp getInterviewnoticeTime() {
        return interviewnoticeTime;
    }

    public void setInterviewnoticeTime(Timestamp interviewnoticeTime) {
        this.interviewnoticeTime = interviewnoticeTime;
    }
}
