package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;


public class FinanceSalaryson {
    private int salarysonId;//id
    private String salarysonName;
    private BigDecimal salarysonExtra;//加班工资
    private BigDecimal salarysonBasic;//基本工资
    private BigDecimal salarysonPerf;//绩效工资
    private BigDecimal salarysonSum;//总工资
    private String salarysonBank;//账户
    private Timestamp salarysonDate;//时间



    public String getSalarysonBank() {
        return salarysonBank;
    }

    public void setSalarysonBank(String salarysonBank) {
        this.salarysonBank = salarysonBank;
    }

    public Timestamp getSalarysonDate() {
        return salarysonDate;
    }

    public void setSalarysonDate(Timestamp salarysonDate) {
        this.salarysonDate = salarysonDate;
    }

    public int getSalarysonId() {
        return salarysonId;
    }

    public void setSalarysonId(int salarysonId) {
        this.salarysonId = salarysonId;
    }


    public String getSalarysonName() {
        return salarysonName;
    }

    public void setSalarysonName(String salarysonName) {
        this.salarysonName = salarysonName;
    }


    public BigDecimal getSalarysonExtra() {
        return salarysonExtra;
    }

    public void setSalarysonExtra(BigDecimal salarysonExtra) {
        this.salarysonExtra = salarysonExtra;
    }


    public BigDecimal getSalarysonBasic() {
        return salarysonBasic;
    }

    public void setSalarysonBasic(BigDecimal salarysonBasic) {
        this.salarysonBasic = salarysonBasic;
    }

    public BigDecimal getSalarysonPerf() {
        return salarysonPerf;
    }

    public void setSalarysonPerf(BigDecimal salarysonPerf) {
        this.salarysonPerf = salarysonPerf;
    }


    public BigDecimal getSalarysonSum() {
        return salarysonSum;
    }

    public void setSalarysonSum(BigDecimal salarysonSum) {
        this.salarysonSum = salarysonSum;
    }


}
