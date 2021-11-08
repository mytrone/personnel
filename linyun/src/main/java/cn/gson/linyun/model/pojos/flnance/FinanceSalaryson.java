package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;


public class FinanceSalaryson {
    private Long id;
    private int salarysonId;
    private String salarysonName;
    private BigDecimal salarysonExtra;
    private BigDecimal salarysonBasic;
    private BigDecimal salarysonPerf;
    private BigDecimal salarysonSum;





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
