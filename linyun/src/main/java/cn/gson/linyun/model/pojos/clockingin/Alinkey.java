package cn.gson.linyun.model.pojos.clockingin;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

public class Alinkey {/*类别表*/
    private Integer alinkeyId;
    private String alinkeyName;
    private Integer alinkeyFather;
    private Collection<ClockinginPunch> clockinginPunchesByAlinkeyId;
    private Collection<ClockinginOvertime> clockinginOvertimesByAlinkeyId;

    public Integer getAlinkeyId() {
        return alinkeyId;
    }

    public void setAlinkeyId(Integer alinkeyId) {
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

    @Override
    public String toString() {
        return "Alinkey{" +
                "alinkeyId=" + alinkeyId +
                ", alinkeyName='" + alinkeyName + '\'' +
                ", alinkeyFather=" + alinkeyFather +
                '}';
    }

    public Collection<ClockinginOvertime> getClockinginOvertimesByAlinkeyId() {
        return clockinginOvertimesByAlinkeyId;
    }

    public void setClockinginOvertimesByAlinkeyId(Collection<ClockinginOvertime> clockinginOvertimesByAlinkeyId) {
        this.clockinginOvertimesByAlinkeyId = clockinginOvertimesByAlinkeyId;
    }
}
