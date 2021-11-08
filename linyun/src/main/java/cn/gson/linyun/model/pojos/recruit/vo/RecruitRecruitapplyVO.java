package cn.gson.linyun.model.pojos.recruit.vo;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import cn.gson.linyun.model.pojos.recruit.RecruitDemand;
import cn.gson.linyun.model.pojos.recruit.RecruitRecruitapply;

public class RecruitRecruitapplyVO {
    private  String recruitapplyTitle;
    private String recruitapplyPosition;
    private Integer recruitapplyPnum;
    private String recruitapplyEducationInf;
    private String recruitapplyEason;
    private ArchivesEmp archivesEmpByEmpId;
    private RecruitDemand recruitDemandByDemandId;

    @Override
    public String toString() {
        return "RecruitRecruitapplyVO{" +
                "recruitapplyTitle='" + recruitapplyTitle + '\'' +
                ", recruitapplyPosition='" + recruitapplyPosition + '\'' +
                ", recruitapplyPnum=" + recruitapplyPnum +
                ", recruitapplyEducationInf='" + recruitapplyEducationInf + '\'' +
                ", recruitapplyEason='" + recruitapplyEason + '\'' +
                ", archivesEmpByEmpId=" + archivesEmpByEmpId +
                '}';
    }

    public RecruitDemand getRecruitDemandByDemandId() {
        return recruitDemandByDemandId;
    }

    public void setRecruitDemandByDemandId(RecruitDemand recruitDemandByDemandId) {
        this.recruitDemandByDemandId = recruitDemandByDemandId;
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

    public ArchivesEmp getArchivesEmpByEmpId() {
        return archivesEmpByEmpId;
    }

    public void setArchivesEmpByEmpId(ArchivesEmp archivesEmpByEmpId) {
        this.archivesEmpByEmpId = archivesEmpByEmpId;
    }


}
