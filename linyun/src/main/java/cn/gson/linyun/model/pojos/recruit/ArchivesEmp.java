package cn.gson.linyun.model.pojos.recruit;

import javax.persistence.*;
import java.sql.Timestamp;
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArchivesEmp that = (ArchivesEmp) o;
        return Objects.equals(empId, that.empId) && Objects.equals(empName, that.empName) && Objects.equals(empsonSex, that.empsonSex) && Objects.equals(empsonCard, that.empsonCard) && Objects.equals(empsonEmail, that.empsonEmail) && Objects.equals(empsonTel, that.empsonTel) && Objects.equals(empsonBank, that.empsonBank) && Objects.equals(empsonEducation, that.empsonEducation) && Objects.equals(empsonDay, that.empsonDay) && Objects.equals(empsonBirthday, that.empsonBirthday) && Objects.equals(topId, that.topId);
    }

    public int hashCode() {
        return Objects.hash(empId, empName, empsonSex, empsonCard, empsonEmail, empsonTel, empsonBank, empsonEducation, empsonDay, empsonBirthday, topId);
    }
}
