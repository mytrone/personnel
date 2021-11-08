package cn.gson.linyun.model.pojos.workflow;

import cn.gson.linyun.model.pojos.clockingin.ClockinginLeave;
import cn.gson.linyun.model.pojos.clockingin.ClockinginOvertime;
import cn.gson.linyun.model.pojos.clockingin.ClockinginPunch;
import cn.gson.linyun.model.pojos.flnance.FinanceTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 类别自连表
 */
public class Alinkey {
    private int alinkeyId;//编号
    private String alinkeyName;//名称
    private Integer alinkeyFather;//上级编号


    private Collection<ClockinginPunch> clockinginPunchesByAlinkeyId;
    private Collection<ClockinginOvertime> clockinginOvertimesByAlinkeyId;

    private Collection<ClockinginLeave> clockinginLeaves;


    private Collection<FinanceTemplate> financeTemplatesByAlinkeyId;

    public int getAlinkeyId() {
        return alinkeyId;
    }

    public void setAlinkeyId(int alinkeyId) {
        this.alinkeyId = alinkeyId;
    }

    public String getAlinkeyName() {
        return alinkeyName;
    }

    public void setAlinkeyName(String alinkeyName) {
        this.alinkeyName = alinkeyName;
    }

    public Integer getAlinkeyFather() {
        return alinkeyFather;
    }

    public void setAlinkeyFather(Integer alinkeyFather) {
        this.alinkeyFather = alinkeyFather;
    }

    public Collection<ClockinginPunch> getClockinginPunchesByAlinkeyId() {
        return clockinginPunchesByAlinkeyId;
    }

    public void setClockinginPunchesByAlinkeyId(Collection<ClockinginPunch> clockinginPunchesByAlinkeyId) {
        this.clockinginPunchesByAlinkeyId = clockinginPunchesByAlinkeyId;
    }

    public Collection<ClockinginOvertime> getClockinginOvertimesByAlinkeyId() {
        return clockinginOvertimesByAlinkeyId;
    }

    public void setClockinginOvertimesByAlinkeyId(Collection<ClockinginOvertime> clockinginOvertimesByAlinkeyId) {
        this.clockinginOvertimesByAlinkeyId = clockinginOvertimesByAlinkeyId;
    }

    public Collection<ClockinginLeave> getClockinginLeaves() {
        return clockinginLeaves;
    }

    public void setClockinginLeaves(Collection<ClockinginLeave> clockinginLeaves) {
        this.clockinginLeaves = clockinginLeaves;
    }

    public Collection<FinanceTemplate> getFinanceTemplatesByAlinkeyId() {
        return financeTemplatesByAlinkeyId;
    }

    public void setFinanceTemplatesByAlinkeyId(Collection<FinanceTemplate> financeTemplatesByAlinkeyId) {
        this.financeTemplatesByAlinkeyId = financeTemplatesByAlinkeyId;
    }
}
