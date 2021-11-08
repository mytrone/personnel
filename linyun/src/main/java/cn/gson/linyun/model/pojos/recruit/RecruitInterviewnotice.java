package cn.gson.linyun.model.pojos.recruit;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

public class RecruitInterviewnotice {
    private Integer interviewnoticeId;
    private String interviewnoticeName;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp interviewnoticeIntime;
    private String interviewnoticeDidian;
    private String interviewnoticeTel;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp interviewnoticeTime;

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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecruitInterviewnotice that = (RecruitInterviewnotice) o;
        return Objects.equals(interviewnoticeId, that.interviewnoticeId) && Objects.equals(interviewnoticeName, that.interviewnoticeName) && Objects.equals(interviewnoticeIntime, that.interviewnoticeIntime) && Objects.equals(interviewnoticeDidian, that.interviewnoticeDidian) && Objects.equals(interviewnoticeTel, that.interviewnoticeTel) && Objects.equals(interviewnoticeTime, that.interviewnoticeTime);
    }

    public int hashCode() {
        return Objects.hash(interviewnoticeId, interviewnoticeName, interviewnoticeIntime, interviewnoticeDidian, interviewnoticeTel, interviewnoticeTime);
    }
}
