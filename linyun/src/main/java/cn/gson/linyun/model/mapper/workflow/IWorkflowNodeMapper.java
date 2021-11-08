package cn.gson.linyun.model.mapper.workflow;


import cn.gson.linyun.model.Vo.FlowVo;
import cn.gson.linyun.model.pojos.workflow.WorkflowNode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IWorkflowNodeMapper {

    /**
     * 根据流程创建节点
     * @return
     */
    Integer Insert(FlowVo flowVo,Integer[] arr);

    /**
     * 根据流程查询节点
     * @param id
     * @return
     */
    List<WorkflowNode> SelectByFlow(Integer id);

    /**
     * 根据职位层级查询已经设计好的流程节点
     * @param id
     * @return
     */
    List<WorkflowNode> SelectByPosition(Integer id);

    /**
     * 流程节点
     * @param id
     * @return
     */
    Integer Delete(Integer id);

}
