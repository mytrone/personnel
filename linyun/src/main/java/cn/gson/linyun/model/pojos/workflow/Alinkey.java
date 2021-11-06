package cn.gson.linyun.model.pojos.workflow;

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


    private Collection<FinanceTemplate> financeTemplatesByAlinkeyId;


}
