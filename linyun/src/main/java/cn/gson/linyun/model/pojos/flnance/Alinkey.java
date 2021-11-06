package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;



public class Alinkey {

    private Collection<FinanceTemplate> financeTemplatesByAlinkeyId;
    private int alinkeyId;//主键
    private String alinkeyName;//类别名
    private Integer alinkeyFather;//自连接

    @OneToMany(mappedBy = "alinkeyByAlinkeyId")
    public Collection<FinanceTemplate> getFinanceTemplatesByAlinkeyId() {
        return financeTemplatesByAlinkeyId;
    }

    public void setFinanceTemplatesByAlinkeyId(Collection<FinanceTemplate> financeTemplatesByAlinkeyId) {
        this.financeTemplatesByAlinkeyId = financeTemplatesByAlinkeyId;
    }




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


}
