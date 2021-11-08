package cn.gson.linyun.model.pojos.flnance;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


public class FinanceCheck {

    private int checkId;//主键
    private Integer checkPoints;//考核总分
    private String checkRemark;//考核评语
    private String checkTemplate;//考核模板名
    private String checkSerial;//考核编号
    private Timestamp checkDate;//时间
    private List<ArchivesEmp> archivesEmpList;//员工
    private ArchivesEmp EmpList;//员工
    private List<FinanceCheckson> financeCheckson;//考核子表
    private int empId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @OneToMany
    public List<ArchivesEmp> getArchivesEmpList() {
        return archivesEmpList;
    }

    public void setArchivesEmpList(List<ArchivesEmp> archivesEmpList) {
        this.archivesEmpList = archivesEmpList;
    }





    @OneToMany
    public List<FinanceCheckson> getFinanceCheckson() {
        return financeCheckson;
    }

    public void setFinanceCheckson(List<FinanceCheckson> financeCheckson) {
        this.financeCheckson = financeCheckson;
    }

    private Integer arcEmpId;


    public int getCheckId() {
        return checkId;
    }

    public void setCheckId(int checkId) {
        this.checkId = checkId;
    }


    public Integer getCheckPoints() {
        return checkPoints;
    }

    public void setCheckPoints(Integer checkPoints) {
        this.checkPoints = checkPoints;
    }


    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }


    public String getCheckTemplate() {
        return checkTemplate;
    }

    public void setCheckTemplate(String checkTemplate) {
        this.checkTemplate = checkTemplate;
    }

    public String getCheckSerial() {
        return checkSerial;
    }

    public void setCheckSerial(String checkSerial) {
        this.checkSerial = checkSerial;
    }

    public Timestamp getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Timestamp checkDate) {
        this.checkDate = checkDate;
    }






    public Integer getArcEmpId() {
        return arcEmpId;
    }

    public void setArcEmpId(Integer arcEmpId) {
        this.arcEmpId = arcEmpId;
    }

    @Override
    public String toString() {
        return "FinanceCheck{" +
                "checkId=" + checkId +
                ", checkPoints=" + checkPoints +
                ", checkRemark='" + checkRemark + '\'' +
                ", checkTemplate='" + checkTemplate + '\'' +
                ", checkSerial='" + checkSerial + '\'' +
                ", checkDate=" + checkDate +
                ", archivesEmpList=" + archivesEmpList +
                ", financeCheckson=" + financeCheckson +
                ", empId=" + empId +
                ", arcEmpId=" + arcEmpId +
                '}';
    }
}
