package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.util.Objects;



public class FinanceCheckson {

    private int checksonId;//主键
    private String checksonName;//项目名
    private int checksonPoints;//上级评分
    private String checksonExplain;//考核说明
    private String checkSerial;//编号
    private int checksonScore;//项目评分

    public String getCheckSerial() {
        return checkSerial;
    }

    public void setCheckSerial(String checkSerial) {
        this.checkSerial = checkSerial;
    }

    public int getChecksonScore() {
        return checksonScore;
    }

    public void setChecksonScore(int checksonScore) {
        this.checksonScore = checksonScore;
    }



    public int getChecksonId() {
        return checksonId;
    }

    public void setChecksonId(int checksonId) {
        this.checksonId = checksonId;
    }



    public String getChecksonName() {
        return checksonName;
    }

    public void setChecksonName(String checksonName) {
        this.checksonName = checksonName;
    }



    public int getChecksonPoints() {
        return checksonPoints;
    }

    public void setChecksonPoints(int checksonPoints) {
        this.checksonPoints = checksonPoints;
    }



    public String getChecksonExplain() {
        return checksonExplain;
    }

    public void setChecksonExplain(String checksonExplain) {
        this.checksonExplain = checksonExplain;
    }

    @Override
    public String toString() {
        return "FinanceCheckson{" +
                "checksonId=" + checksonId +
                ", checksonName='" + checksonName + '\'' +
                ", checksonPoints=" + checksonPoints +
                ", checksonExplain='" + checksonExplain + '\'' +
                ", checkSerial='" + checkSerial + '\'' +
                ", checksonScore=" + checksonScore +
                '}';
    }
}
