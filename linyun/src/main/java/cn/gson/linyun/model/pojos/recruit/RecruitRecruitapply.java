package cn.gson.linyun.model.pojos.recruit;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


public class RecruitRecruitapply {
    private Integer recruitapplyId;
    private String recruitapplyTitle;
    private String recruitapplyPosition;
    private Integer recruitapplyPnum;
    private String recruitapplyEducationInf;
    private String recruitapplyEason;
    //时间转换格式
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Timestamp recruitapplyTime;

    private Integer recruitapplyState;
    private ArchivesEmp archivesEmpByEmpId;
    private RecruitDemand recruitDemandByDemandId;

    @Override
    public String toString() {
        return "RecruitRecruitapply{" +
                "recruitapplyId=" + recruitapplyId +
                ", recruitapplyTitle='" + recruitapplyTitle + '\'' +
                ", recruitapplyPosition='" + recruitapplyPosition + '\'' +
                ", recruitapplyPnum=" + recruitapplyPnum +
                ", recruitapplyEducationInf='" + recruitapplyEducationInf + '\'' +
                ", recruitapplyEason='" + recruitapplyEason + '\'' +
                ", recruitapplyTime=" + recruitapplyTime +
                ", recruitapplyState=" + recruitapplyState +
                '}';
    }

    public Integer getRecruitapplyId() {
        return recruitapplyId;
    }

    public void setRecruitapplyId(Integer recruitapplyId) {
        this.recruitapplyId = recruitapplyId;
    }

    public String getRecruitapplyTitle() {
        return recruitapplyTitle;
    }

    public void setRecruitapplyTitle(String recruitapplyTitle) {
        this.recruitapplyTitle = recruitapplyTitle;
    }

    public String getRecruitapplyPosition() {
        return recruitapplyPosition;
    }

    public void setRecruitapplyPosition(String recruitapplyPosition) {
        this.recruitapplyPosition = recruitapplyPosition;
    }

    public Integer getRecruitapplyPnum() {
        return recruitapplyPnum;
    }

    public void setRecruitapplyPnum(Integer recruitapplyPnum) {
        this.recruitapplyPnum = recruitapplyPnum;
    }

    public String getRecruitapplyEducationInf() {
        return recruitapplyEducationInf;
    }

    public void setRecruitapplyEducationInf(String recruitapplyEducationInf) {
        this.recruitapplyEducationInf = recruitapplyEducationInf;
    }

    public String getRecruitapplyEason() {
        return recruitapplyEason;
    }

    public void setRecruitapplyEason(String recruitapplyEason) {
        this.recruitapplyEason = recruitapplyEason;
    }

    public Timestamp getRecruitapplyTime() {
        return recruitapplyTime;
    }

    public void setRecruitapplyTime(Timestamp recruitapplyTime) {
        this.recruitapplyTime = recruitapplyTime;
    }

    public Integer getRecruitapplyState() {
        return recruitapplyState;
    }

    public void setRecruitapplyState(Integer recruitapplyState) {
        this.recruitapplyState = recruitapplyState;
    }

    @ManyToOne
    public ArchivesEmp getArchivesEmpByEmpId() {
        return archivesEmpByEmpId;
    }

    public void setArchivesEmpByEmpId(ArchivesEmp archivesEmpByEmpId) {
        this.archivesEmpByEmpId = archivesEmpByEmpId;
    }

    public RecruitDemand getRecruitDemandByDemandId() {
        return recruitDemandByDemandId;
    }

    public void setRecruitDemandByDemandId(RecruitDemand recruitDemandByDemandId) {
        this.recruitDemandByDemandId = recruitDemandByDemandId;
    }
}
