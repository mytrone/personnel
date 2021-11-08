package cn.gson.linyun.model.pojos.workflow;

import cn.gson.linyun.model.pojos.recruit.ArchivesEmp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 通知人员
 */
public class WorkflowPersonnel {
    private int personnelId;//编号
    private Integer personneState;//状态
    private WorkflowNotice workflowNotice;//通知
    private ArchivesEmp archivesEmp;//人员


}
