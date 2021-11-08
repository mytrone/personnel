package cn.gson.linyun.model.mapper.workflow;

import cn.gson.linyun.model.Vo.WorkflowApproveVo;
import cn.gson.linyun.model.pojos.workflow.WorkflowApprove;
import cn.gson.linyun.model.pojos.workflow.WorkflowFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IWorkflowApproveMapper {

    /**
     * 根据申请编号 流程 查询
     * @param id
     * @return
     */
     WorkflowApprove SelectBYid(@Param("id") Integer id,@Param("flow") Integer flow);

    /**
     * 创建申请实例
     * @param workflowApprove
     * @return
     */
     Integer Insert(WorkflowApproveVo workflowApprove);

    /**
     * 查询所有申请
     * @return
     */
    List<WorkflowApprove> SelectAll(@Param("name") String name);

    /**
     * 根据用户编号查询
     * @return
     */
    List<WorkflowApprove> SelectByEmp(@Param("id") Integer id,@Param("name")String name);

    /**
     * 查询需要我办理的
     * @return
     */
    List<WorkflowApprove> SelectByEmpSp(@Param("emp") Integer emp,

                                        @Param("name")String name);

    /**
     * 查询历史审批记录 根据流程实例编号
     * @return
     */
   WorkflowApprove SelectHistory(Integer id);

    /**
     * 根据流程实例编号查询记录
     * @param id
     * @return
     */
    List<WorkflowApprove> SelectByApprove(Integer id);

    /**
     * 修改状态
     * @param id
     * @return
     */
   Integer Update(@Param("id") Integer id,@Param("state") Integer state);

   /**
     * 修改节点flow
     * @param id
     * @return
     */
   Integer UpdateNode(@Param("id") Integer id,@Param("node") Integer state);

}
