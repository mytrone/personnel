package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;


public class Relationship34 {

    private FinanceItem financeItemByItemId;
    private FinanceTemplate financeTemplateByTemplateId;




    @ManyToOne
    @JoinColumn(name = "Item_id", referencedColumnName = "Item_id", nullable = false)
    public FinanceItem getFinanceItemByItemId() {
        return financeItemByItemId;
    }

    public void setFinanceItemByItemId(FinanceItem financeItemByItemId) {
        this.financeItemByItemId = financeItemByItemId;
    }

    @ManyToOne
    @JoinColumn(name = "template_id", referencedColumnName = "template_id", nullable = false)
    public FinanceTemplate getFinanceTemplateByTemplateId() {
        return financeTemplateByTemplateId;
    }

    public void setFinanceTemplateByTemplateId(FinanceTemplate financeTemplateByTemplateId) {
        this.financeTemplateByTemplateId = financeTemplateByTemplateId;
    }
}
