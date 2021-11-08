package cn.gson.linyun.model.pojos.recruit;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

public class RecruitDemand {
    private Integer demandId;
    private String demandName;
    private String demandPosition;
    private String demandPositionInf;
    private String demandWorkyear;
    private String demandAddress;
    private String demandTel;
    private String demandMoney;
    //时间转换格式
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp demandTime;
    private Integer demandState;
    private RecruitRecruitapply recruitRecruitapplyByRecruitapplyId;

    @Override
    public String toString() {
        return "RecruitDemand{" +
                "demandId=" + demandId +
                ", demandName='" + demandName + '\'' +
                ", demandPosition='" + demandPosition + '\'' +
                ", demandPositionInf='" + demandPositionInf + '\'' +
                ", demandWorkyear='" + demandWorkyear + '\'' +
                ", demandAddress='" + demandAddress + '\'' +
                ", demandTel='" + demandTel + '\'' +
                ", demandMoney='" + demandMoney + '\'' +
                ", demandTime=" + demandTime +
                ", demandState=" + demandState +
                '}';
    }

    public Integer getDemandId() {
        return demandId;
    }

    public void setDemandId(Integer demandId) {
        this.demandId = demandId;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getDemandPosition() {
        return demandPosition;
    }

    public void setDemandPosition(String demandPosition) {
        this.demandPosition = demandPosition;
    }

    public String getDemandPositionInf() {
        return demandPositionInf;
    }

    public void setDemandPositionInf(String demandPositionInf) {
        this.demandPositionInf = demandPositionInf;
    }

    public String getDemandWorkyear() {
        return demandWorkyear;
    }

    public void setDemandWorkyear(String demandWorkyear) {
        this.demandWorkyear = demandWorkyear;
    }

    public String getDemandAddress() {
        return demandAddress;
    }

    public void setDemandAddress(String demandAddress) {
        this.demandAddress = demandAddress;
    }

    public String getDemandTel() {
        return demandTel;
    }

    public void setDemandTel(String demandTel) {
        this.demandTel = demandTel;
    }

    public String getDemandMoney() {
        return demandMoney;
    }

    public void setDemandMoney(String demandMoney) {
        this.demandMoney = demandMoney;
    }

    public Timestamp getDemandTime() {
        return demandTime;
    }

    public void setDemandTime(Timestamp demandTime) {
        this.demandTime = demandTime;
    }

    public Integer getDemandState() {
        return demandState;
    }

    public void setDemandState(Integer demandState) {
        this.demandState = demandState;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecruitDemand that = (RecruitDemand) o;
        return Objects.equals(demandId, that.demandId) && Objects.equals(demandName, that.demandName) && Objects.equals(demandPosition, that.demandPosition) && Objects.equals(demandPositionInf, that.demandPositionInf) && Objects.equals(demandWorkyear, that.demandWorkyear) && Objects.equals(demandAddress, that.demandAddress) && Objects.equals(demandTel, that.demandTel) && Objects.equals(demandMoney, that.demandMoney) && Objects.equals(demandTime, that.demandTime) && Objects.equals(demandState, that.demandState);
    }

    public int hashCode() {
        return Objects.hash(demandId, demandName, demandPosition,demandPositionInf, demandWorkyear, demandAddress, demandTel, demandMoney, demandTime, demandState);
    }

    public RecruitRecruitapply getRecruitRecruitapplyByRecruitapplyId() {
        return recruitRecruitapplyByRecruitapplyId;
    }

    public void setRecruitRecruitapplyByRecruitapplyId(RecruitRecruitapply recruitRecruitapplyByRecruitapplyId) {
        this.recruitRecruitapplyByRecruitapplyId = recruitRecruitapplyByRecruitapplyId;
    }

}
