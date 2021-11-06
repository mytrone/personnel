package cn.gson.linyun.model.pojos.flnance;

import javax.persistence.*;
import java.util.Collection;


public class ArchivesEmp {
    private Long id;
    private Collection<FinanceTemplate> financeTemplatesByEmpId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "archivesEmpByEmpId")
    public Collection<FinanceTemplate> getFinanceTemplatesByEmpId() {
        return financeTemplatesByEmpId;
    }

    public void setFinanceTemplatesByEmpId(Collection<FinanceTemplate> financeTemplatesByEmpId) {
        this.financeTemplatesByEmpId = financeTemplatesByEmpId;
    }
}
