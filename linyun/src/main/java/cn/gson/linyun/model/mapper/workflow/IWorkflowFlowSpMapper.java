package cn.gson.linyun.model.mapper.workflow;

import cn.gson.linyun.model.Vo.WorkflowFlowSpVo;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlowSp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

@Mapper
public interface IWorkflowFlowSpMapper {

    /**
     * 审批节点创建
     * @param spVo
     * @return
     */
    Integer Insert(WorkflowFlowSpVo spVo);

    /**
     * 修改审批状态
     * @return
     */
    Integer Update(@Param("id") Integer id,
                   @Param("state") Boolean state,
                   @Param("row") String row,
                   @Param("time") Timestamp timestamp);

    /**
     * 修改审批人
     * @param id
     * @param emp
     * @return
     */
    Integer UpdateEmp(@Param("id") Integer id,@Param("emp") Integer emp);


}
