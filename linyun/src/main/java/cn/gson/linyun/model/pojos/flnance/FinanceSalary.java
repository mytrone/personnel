package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;


public class FinanceSalary {

    private int salaryId;
    private String salaryArticle;
    private BigDecimal salarySum;
    private Timestamp salaryDate;
    private String salarySerial;


    public int getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }


    public String getSalaryArticle() {
        return salaryArticle;
    }

    public void setSalaryArticle(String salaryArticle) {
        this.salaryArticle = salaryArticle;
    }


    public BigDecimal getSalarySum() {
        return salarySum;
    }

    public void setSalarySum(BigDecimal salarySum) {
        this.salarySum = salarySum;
    }


    public Timestamp getSalaryDate() {
        return salaryDate;
    }

    public void setSalaryDate(Timestamp salaryDate) {
        this.salaryDate = salaryDate;
    }

    public String getSalarySerial() {
        return salarySerial;
    }

    public void setSalarySerial(String salarySerial) {
        this.salarySerial = salarySerial;
    }


}