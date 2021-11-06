package cn.gson.linyun.model.pojos.clockingin;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

public class ArchivesEmp {
    private Integer empId;
    private String empName;
    private String empsonSex;
    private String empsonCard;
    private String empsonEmail;
    private Integer empsonTel;
    private String empsonBank;
    private String empsonEducation;
    private Timestamp empsonDay;
    private Timestamp empsonBirthday;
    private Integer topId;
    private Collection<ClockinginOvertime> clockinginOvertimesByEmpId;
    private Collection<ClockinginOvertime> clockinginOvertimesByEmpId_0;

    @Override
    public String toString() {
        return "ArchivesEmp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empsonSex='" + empsonSex + '\'' +
                ", empsonCard='" + empsonCard + '\'' +
                ", empsonEmail='" + empsonEmail + '\'' +
                ", empsonTel=" + empsonTel +
                ", empsonBank='" + empsonBank + '\'' +
                ", empsonEducation='" + empsonEducation + '\'' +
                ", empsonDay=" + empsonDay +
                ", empsonBirthday=" + empsonBirthday +
                ", topId=" + topId +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpsonSex() {
        return empsonSex;
    }

    public void setEmpsonSex(String empsonSex) {
        this.empsonSex = empsonSex;
    }

    public String getEmpsonCard() {
        return empsonCard;
    }

    public void setEmpsonCard(String empsonCard) {
        this.empsonCard = empsonCard;
    }

    public String getEmpsonEmail() {
        return empsonEmail;
    }

    public void setEmpsonEmail(String empsonEmail) {
        this.empsonEmail = empsonEmail;
    }

    public Integer getEmpsonTel() {
        return empsonTel;
    }

    public void setEmpsonTel(Integer empsonTel) {
        this.empsonTel = empsonTel;
    }

    public String getEmpsonBank() {
        return empsonBank;
    }

    public void setEmpsonBank(String empsonBank) {
        this.empsonBank = empsonBank;
    }

    public String getEmpsonEducation() {
        return empsonEducation;
    }

    public void setEmpsonEducation(String empsonEducation) {
        this.empsonEducation = empsonEducation;
    }

    public Timestamp getEmpsonDay() {
        return empsonDay;
    }

    public void setEmpsonDay(Timestamp empsonDay) {
        this.empsonDay = empsonDay;
    }

    public Timestamp getEmpsonBirthday() {
        return empsonBirthday;
    }

    public void setEmpsonBirthday(Timestamp empsonBirthday) {
        this.empsonBirthday = empsonBirthday;
    }

    public Integer getTopId() {
        return topId;
    }

    public void setTopId(Integer topId) {
        this.topId = topId;
    }

    public Collection<ClockinginOvertime> getClockinginOvertimesByEmpId() {
        return clockinginOvertimesByEmpId;
    }

    public void setClockinginOvertimesByEmpId(Collection<ClockinginOvertime> clockinginOvertimesByEmpId) {
        this.clockinginOvertimesByEmpId = clockinginOvertimesByEmpId;
    }

    public Collection<ClockinginOvertime> getClockinginOvertimesByEmpId_0() {
        return clockinginOvertimesByEmpId_0;
    }

    public void setClockinginOvertimesByEmpId_0(Collection<ClockinginOvertime> clockinginOvertimesByEmpId_0) {
        this.clockinginOvertimesByEmpId_0 = clockinginOvertimesByEmpId_0;
    }
}
