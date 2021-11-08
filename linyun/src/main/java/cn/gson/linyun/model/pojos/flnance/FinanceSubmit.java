package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class FinanceSubmit {

    private int submitId;
    private String submitSerial;
    private BigDecimal submitSum;
    private Timestamp submitDate;


    public int getSubmitId() {
        return submitId;
    }

    public void setSubmitId(int submitId) {
        this.submitId = submitId;
    }


    public String getSubmitSerial() {
        return submitSerial;
    }

    public void setSubmitSerial(String submitSerial) {
        this.submitSerial = submitSerial;
    }


    public BigDecimal getSubmitSum() {
        return submitSum;
    }

    public void setSubmitSum(BigDecimal submitSum) {
        this.submitSum = submitSum;
    }


    public Timestamp getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
    }


}
