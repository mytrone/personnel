package cn.gson.linyun.model.pojos.recruit.vo;

import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;

import java.sql.Timestamp;

public class RecruitDemandVO {
    private String demandName;
    private Integer rId;
    private String demandPosition;
    private String demandPositionInf;
    private String demandWorkyear;
    private String demandAddress;
    private String demandTel;
    private String demandMoney;
    private RecruitRecruitapply recruitRecruitapplyByRecruitapplyId;

    @Override
    public String toString() {
        return "RecruitDemandVO{" +
                "demandName='" + demandName + '\'' +
                ", demandPosition='" + demandPosition + '\'' +
                ", demandPositionInf='" + demandPositionInf + '\'' +
                ", demandWorkyear='" + demandWorkyear + '\'' +
                ", demandAddress='" + demandAddress + '\'' +
                ", demandTel='" + demandTel + '\'' +
                ", demandMoney='" + demandMoney + '\'' +
                ", recruitRecruitapplyByRecruitapplyId=" + recruitRecruitapplyByRecruitapplyId +
                '}';
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
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

    public RecruitRecruitapply getRecruitRecruitapplyByRecruitapplyId() {
        return recruitRecruitapplyByRecruitapplyId;
    }

    public void setRecruitRecruitapplyByRecruitapplyId(RecruitRecruitapply recruitRecruitapplyByRecruitapplyId) {
        this.recruitRecruitapplyByRecruitapplyId = recruitRecruitapplyByRecruitapplyId;
    }
}
