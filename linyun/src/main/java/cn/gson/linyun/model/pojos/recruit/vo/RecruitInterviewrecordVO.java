package cn.gson.linyun.model.pojos.recruit.vo;

import java.sql.Timestamp;

public class RecruitInterviewrecordVO {
    private String interviewrecordName;
    private String interviewrecordInterviewer;
    private Timestamp interviewrecordTime;
    private Integer interviewrecordNumber;

    @Override
    public String toString() {
        return "RecruitInterviewrecordVO{" +
                "interviewrecordName='" + interviewrecordName + '\'' +
                ", interviewrecordInterviewer='" + interviewrecordInterviewer + '\'' +
                ", interviewrecordTime=" + interviewrecordTime +
                ", interviewrecordNumber=" + interviewrecordNumber +
                '}';
    }

    public String getInterviewrecordName() {
        return interviewrecordName;
    }

    public void setInterviewrecordName(String interviewrecordName) {
        this.interviewrecordName = interviewrecordName;
    }

    public String getInterviewrecordInterviewer() {
        return interviewrecordInterviewer;
    }

    public void setInterviewrecordInterviewer(String interviewrecordInterviewer) {
        this.interviewrecordInterviewer = interviewrecordInterviewer;
    }

    public Timestamp getInterviewrecordTime() {
        return interviewrecordTime;
    }

    public void setInterviewrecordTime(Timestamp interviewrecordTime) {
        this.interviewrecordTime = interviewrecordTime;
    }

    public Integer getInterviewrecordNumber() {
        return interviewrecordNumber;
    }

    public void setInterviewrecordNumber(Integer interviewrecordNumber) {
        this.interviewrecordNumber = interviewrecordNumber;
    }
}
