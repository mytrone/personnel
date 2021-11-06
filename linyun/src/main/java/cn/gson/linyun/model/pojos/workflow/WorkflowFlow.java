package cn.gson.linyun.model.pojos.workflow;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * 流程
 */
public class WorkflowFlow {
    private int flowId;
    private String flowName;
    private Boolean flowState;
    private String flowUrl;
    private Alinkey alinkey;//流程类型
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp flowTime;
    private Integer flowPosition;


}
