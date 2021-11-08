package cn.gson.linyun.model.pojos.recruit;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

public class RecruitInterviewrecord {
    private Integer interviewrecordId;
    private String interviewrecordName;
    private String interviewrecordInterviewer;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp interviewrecordTime;
    private Integer interviewrecordNumber;

    public Integer getInterviewrecordId() {
        return interviewrecordId;
    }

    public void setInterviewrecordId(Integer interviewrecordId) {
        this.interviewrecordId = interviewrecordId;
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecruitInterviewrecord that = (RecruitInterviewrecord) o;
        return Objects.equals(interviewrecordId, that.interviewrecordId) && Objects.equals(interviewrecordName, that.interviewrecordName) && Objects.equals(interviewrecordInterviewer, that.interviewrecordInterviewer) && Objects.equals(interviewrecordTime, that.interviewrecordTime) && Objects.equals(interviewrecordNumber, that.interviewrecordNumber);
    }

    public int hashCode() {
        return Objects.hash(interviewrecordId, interviewrecordName, interviewrecordInterviewer, interviewrecordTime, interviewrecordNumber);
    }
}
